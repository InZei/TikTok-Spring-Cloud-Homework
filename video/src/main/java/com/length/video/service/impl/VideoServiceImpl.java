package com.length.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.video.dao.VideoDao;
import com.length.video.entity.Video;
import com.length.video.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * (Video)表服务实现类
 *
 * @author PQF
 * @since 2020-10-30 20:02:13
 */
@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {

}