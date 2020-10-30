package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.FollowDao;
import com.length.video.entity.Follow;
import com.length.video.service.FollowService;
import org.springframework.stereotype.Service;

/**
 * (Follow)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 20:01:55
 */
@Service("followService")
public class FollowServiceImpl extends ServiceImpl<FollowDao, Follow> implements FollowService {

}