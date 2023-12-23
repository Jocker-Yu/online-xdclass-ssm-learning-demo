package com.xdclass.net.onlinexdclass.service;

import com.xdclass.net.onlinexdclass.entity.Video;
import com.xdclass.net.onlinexdclass.entity.VideoBanner;
import java.util.List;

/**
 * @description: 视频服务
 * @author: Joker.yu 2023-12-23 13:37
 */
public interface VideoService {

  /**
   * 查询轮播图
   *
   * @return 轮播图
   */
  List<VideoBanner> listBanner();

  /**
   * 查询视频列表
   *
   * @return 视频列表
   */
  List<Video> listVideo();

  /**
   * 查询视频详情
   *
   * @param videoId 视频id
   * @return 查询视频详情
   */
  Video findDetailById(Integer videoId);
}
