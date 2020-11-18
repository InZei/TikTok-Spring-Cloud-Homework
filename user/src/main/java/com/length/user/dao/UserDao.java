package com.length.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.length.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author PQF
 * @since 2020-11-18 16:25:23
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}