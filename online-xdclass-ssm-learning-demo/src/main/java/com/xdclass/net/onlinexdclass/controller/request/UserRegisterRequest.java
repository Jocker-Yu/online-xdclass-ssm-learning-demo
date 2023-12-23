package com.xdclass.net.onlinexdclass.controller.request;

import lombok.Data;

/**
 * @description: 用户注册请求类
 * @author: Joker.yu 2023-12-23 09:57
 */
@Data
public class UserRegisterRequest {

  /** 名称 */
  private String name;

  /** 手机 */
  private String phone;

  /** 密码 */
  private String pwd;
}
