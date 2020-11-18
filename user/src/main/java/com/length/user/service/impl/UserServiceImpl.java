package com.length.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.length.user.dao.UserDao;
import com.length.user.entity.User;
import com.length.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author PQF
 * @since 2020-11-18 16:25:25
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}