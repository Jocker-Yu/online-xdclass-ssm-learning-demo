package com.xdclass.net.onlinexdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

/**
 * `id` int(11) unsigned NOT NULL AUTO_INCREMENT, `name` varchar(128) DEFAULT NULL COMMENT '昵称',
 * `pwd` varchar(124) DEFAULT NULL COMMENT '密码', `head_img` varchar(524) DEFAULT NULL COMMENT '头像',
 * `phone` varchar(64) DEFAULT '' COMMENT '手机号', `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 */
@Data
public class User {

  private Integer id;

  private String name;

  @JsonIgnore private String pwd;

  @JsonProperty("head_img")
  private String headImg;

  private String phone;

  @JsonProperty("create_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
