package com.length.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.length.video.dao.PageDao;
import com.length.video.entity.Likes;
import com.length.video.entity.PageResult;

/**
 * (Likes)表服务接口
 *
 * @author PQF
 * @since 2020-10-30 19:59:06
 */
public interface LikesService extends IService<Likes> {
    PageResult<Likes> queryAll(PageDao page, Likes likes);
}