package com.xdclass.net.onlinexdclass.service;

import com.xdclass.net.onlinexdclass.controller.request.LoginRequest;
import com.xdclass.net.onlinexdclass.controller.request.UserRegisterRequest;
import com.xdclass.net.onlinexdclass.entity.User;

/**
 * @description: 用户服务类
 * @author: Joker.yu 2023-12-23 09:03
 */
public interface UserService {

  /**
   * 用户注册
   *
   * @param registerRequest registerRequest
   */
  void register(UserRegisterRequest registerRequest);

  /**
   * 登录
   *
   * @param loginRequest loginRequest
   */
  String login(LoginRequest loginRequest);

  /**
   * 查询用户信息
   *
   * @param userId userId
   */
  User findByUserId(Integer userId);
}
