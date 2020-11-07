package com.length.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.length.video.dao.PageDao;
import com.length.video.entity.Follow;
import com.length.video.entity.PageResult;

/**
 * (Follow)表服务接口
 *
 * @author PQF
 * @since 2020-10-30 20:01:55
 */
public interface FollowService extends IService<Follow> {
    PageResult<Follow> queryAll(PageDao page, Follow follow);
}