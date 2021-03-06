package com.length.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.length.video.entity.Likes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Likes)表数据库访问层
 *
 * @author PQF
 * @since 2020-10-30 19:59:05
 */
@Mapper
public interface LikesDao extends BaseMapper<Likes> {

    List<Likes> queryAll(Likes likes, String orderBy, int begin, int count);
}