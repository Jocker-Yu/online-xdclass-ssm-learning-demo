package com.xdclass.net.onlinexdclass.controller;

import com.xdclass.net.onlinexdclass.entity.Video;
import com.xdclass.net.onlinexdclass.entity.VideoBanner;
import com.xdclass.net.onlinexdclass.service.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 视频控制器
 * @author: Joker.yu 2023-12-23 13:37
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

  @Autowired private VideoService videoService;

  /**
   * 轮播图列表
   *
   * @return 轮播图
   */
  @GetMapping("list_banner")
  public List<VideoBanner> indexBanner() {
    return videoService.listBanner();
  }

  /**
   * 视频列表
   *
   * @return 视频列表
   */
  @GetMapping("list")
  public List<Video> listVideo() {
    return videoService.listVideo();
  }

  /**
   * 查询视频详情，包含章，集信息
   *
   * @param videoId 视频id
   * @return 视频详情
   */
  @GetMapping("find_detail_by_id")
  public Video findDetailById(@RequestParam(value = "video_id") int videoId) {
    return videoService.findDetailById(videoId);
  }
}
