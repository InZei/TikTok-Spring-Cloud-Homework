package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.LikesDao;
import com.length.video.dao.PageDao;
import com.length.video.entity.Likes;
import com.length.video.entity.PageResult;
import com.length.video.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Likes)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 19:59:07
 */
@Service("likesService")
public class LikesServiceImpl extends ServiceImpl<LikesDao, Likes> implements LikesService {
    @Autowired(required=false)
    LikesDao likesDao;

    public PageResult<Likes> queryAll(PageDao page, Likes likes){
        int begin=(page.pageNum-1)*page.pageSize;
        int count=page.pageSize;
        String orderBy=page.orderBy;

        List<Likes> listSum=likesDao.queryAll(likes,orderBy,-1,0);
        List<Likes> listRes=likesDao.queryAll(likes,orderBy,begin,count);

        PageResult<Likes> res=new PageResult<>();

        res.result=listRes;
        res.setPage(page);
        res.total=listSum.size();

        return res;
    }
}