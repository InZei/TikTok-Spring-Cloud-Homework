package com.length.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.length.video.entity.Video;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Video)表数据库访问层
 *
 * @author PQF
 * @since 2020-10-30 20:02:13
 */
@Mapper
public interface VideoDao extends BaseMapper<Video> {

}