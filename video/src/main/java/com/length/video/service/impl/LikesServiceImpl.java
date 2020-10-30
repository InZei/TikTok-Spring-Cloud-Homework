package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.LikesDao;
import com.length.video.entity.Likes;
import com.length.video.service.LikesService;
import org.springframework.stereotype.Service;

/**
 * (Likes)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 19:59:07
 */
@Service("likesService")
public class LikesServiceImpl extends ServiceImpl<LikesDao, Likes> implements LikesService {

}