package com.xdclass.net.onlinexdclass.service.impl;

import com.xdclass.net.onlinexdclass.controller.request.LoginRequest;
import com.xdclass.net.onlinexdclass.controller.request.UserRegisterRequest;
import com.xdclass.net.onlinexdclass.entity.User;
import com.xdclass.net.onlinexdclass.exception.XDException;
import com.xdclass.net.onlinexdclass.mapper.UserMapper;
import com.xdclass.net.onlinexdclass.service.UserService;
import com.xdclass.net.onlinexdclass.utils.CommonUtils;
import com.xdclass.net.onlinexdclass.utils.JWTUtils;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 用户服务
 * @author: Joker.yu 2023-12-23 09:55
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;

  /** 放在CDN上的随机头像 */
  private static final String[] headImg = {
    "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
    "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
    "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
    "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
    "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
  };

  @Override
  @Transactional
  public void register(UserRegisterRequest registerRequest) {
    try {
      userMapper.save(builder(registerRequest));
    } catch (RuntimeException exception) {
      exception.printStackTrace();
      throw new XDException(-1, "注册失败!");
    }
  }

  @Override
  public String login(LoginRequest loginRequest) {
    User user =
        userMapper.findByPhoneAndPwd(
            loginRequest.getPhone(), CommonUtils.MD5(loginRequest.getPwd()));
    return Optional.ofNullable(user)
        .map(JWTUtils::geneJsonWebToken)
        .orElseThrow(() -> new XDException(-1, "账号或密码不正确，请重新输入!"));
  }

  @Override
  public User findByUserId(Integer userId) {
   return userMapper.findByUserId(userId);
  }

  /**
   * 解析 user 对象
   *
   * @param request request
   * @return User
   */
  private User builder(UserRegisterRequest request) {
    User user = new User();
    user.setName(request.getName());
    user.setHeadImg(getRandomImg());
    user.setCreateTime(new Date());
    user.setPhone(request.getPhone());
    user.setPwd(CommonUtils.MD5(request.getPwd()));
    return user;
  }

  /**
   * 获取随机头像
   *
   * @return 头像
   */
  private String getRandomImg() {
    int size = headImg.length;
    Random random = new Random();
    int index = random.nextInt(size);
    return headImg[index];
  }
}
