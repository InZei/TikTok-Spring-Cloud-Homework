package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.FollowDao;
import com.length.video.dao.PageDao;
import com.length.video.entity.Follow;
import com.length.video.entity.PageResult;
import com.length.video.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Follow)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 20:01:55
 */
@Service("followService")
public class FollowServiceImpl extends ServiceImpl<FollowDao, Follow> implements FollowService {
    @Autowired(required=false)
    FollowDao followDao;

    public PageResult<Follow> queryAll(PageDao page, Follow follow){
        int begin=(page.pageNum-1)*page.pageSize;
        int count=page.pageSize;
        String orderBy=page.orderBy;

        List<Follow> listSum=followDao.queryAll(follow,orderBy,-1,0);
        List<Follow> listRes=followDao.queryAll(follow,orderBy,begin,count);

        PageResult<Follow> res=new PageResult<>();

        res.result=listRes;
        res.setPage(page);
        res.total=listSum.size();

        return res;
    }
}