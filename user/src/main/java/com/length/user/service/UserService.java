package com.length.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.length.user.entity.User;

import javax.servlet.http.HttpServletResponse;

/**
 * (User)表服务接口
 *
 * @author PQF
 * @since 2020-11-18 16:25:24
 */
public interface UserService extends IService<User> {
    public void sendImg(HttpServletResponse response, String path);
}