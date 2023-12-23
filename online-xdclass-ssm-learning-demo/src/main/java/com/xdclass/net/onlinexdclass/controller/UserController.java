package com.xdclass.net.onlinexdclass.controller;

import com.xdclass.net.onlinexdclass.controller.request.LoginRequest;
import com.xdclass.net.onlinexdclass.controller.request.UserRegisterRequest;
import com.xdclass.net.onlinexdclass.entity.User;
import com.xdclass.net.onlinexdclass.mapper.VideoMapper;
import com.xdclass.net.onlinexdclass.service.UserService;
import com.xdclass.net.onlinexdclass.utils.JsonData;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: VideoOrder 控制器
 * @author: Joker.yu 2023-12-20 16:19
 */
@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

  @Autowired public UserService userService;

  /**
   * 注册
   *
   * @param request request
   */
  @PostMapping("register")
  public void register(@RequestBody UserRegisterRequest request) {
    userService.register(request);
  }

  /**
   * 登录
   *
   * @param request request
   */
  @PostMapping("login")
  public String login(@RequestBody LoginRequest request) {
    return userService.login(request);
  }

  /**
   * 查询用户信息
   *
   * @param request request
   */
  @PostMapping("find_by_token")
  public JsonData findUserInfoByToken(HttpServletRequest request) {
    Integer userId = (Integer) request.getAttribute("user_id");
    return Optional.ofNullable(userId)
        .map(id -> JsonData.buildSuccess(userService.findByUserId(id)))
        .orElse(JsonData.buildError("用户不存在!"));
  }
}
