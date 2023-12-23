package com.xdclass.net.onlinexdclass.config;

/**
 * @description: 缓存key管理类
 * @author: Joker.yu 2023-12-22 15:10
 */
public class CacheKeyManager {

  /** 首页轮播图缓存key */
  public static final String INDEX_BANNER_KEY = "index:banner:list";

  /** 首页视频列表缓存key */
  public static final String INDEX_VIDEL_LIST = "index:video:list";

  /** 视频详情缓存key, %s是视频id */
  public static final String VIDEO_DETAIL = "video:detail:%s";
}
