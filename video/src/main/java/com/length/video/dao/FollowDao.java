package com.length.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.length.video.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Follow)表数据库访问层
 *
 * @author PQF
 * @since 2020-10-30 20:01:55
 */
@Mapper
public interface FollowDao extends BaseMapper<Follow> {

}