package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.PageDao;
import com.length.video.dao.RemarkDao;
import com.length.video.entity.PageResult;
import com.length.video.entity.Remark;
import com.length.video.entity.Video;
import com.length.video.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Remark)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 20:01:38
 */
@Service("remarkService")
public class RemarkServiceImpl extends ServiceImpl<RemarkDao, Remark> implements RemarkService {
    @Autowired(required=false)
    RemarkDao remarkDao;

    /**
     *
     * @param page
     * @param remark
     * @return
     */
    public PageResult<Remark> queryAll(PageDao page, Remark remark){
        int begin=(page.pageNum-1)*page.pageSize;
        int count=page.pageSize;
        String orderBy=page.orderBy;

        List<Remark> listSum=remarkDao.queryAll(remark,orderBy,-1,0);
        List<Remark> listRes=remarkDao.queryAll(remark,orderBy,begin,count);

        PageResult<Remark> res=new PageResult<>();

        res.result=listRes;
        res.setPage(page);
        res.total=listSum.size();

        return res;
    }
}