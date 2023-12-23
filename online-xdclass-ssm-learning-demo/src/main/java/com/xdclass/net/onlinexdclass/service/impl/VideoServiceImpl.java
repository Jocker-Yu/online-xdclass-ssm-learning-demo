package com.xdclass.net.onlinexdclass.service.impl;

import com.xdclass.net.onlinexdclass.entity.Video;
import com.xdclass.net.onlinexdclass.entity.VideoBanner;
import com.xdclass.net.onlinexdclass.mapper.VideoMapper;
import com.xdclass.net.onlinexdclass.service.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Joker.yu 2023-12-23 13:38
 */
@Service
public class VideoServiceImpl implements VideoService {

  @Autowired private VideoMapper videoMapper;

  @Override
  public List<VideoBanner> listBanner() {
    return videoMapper.listVideoBanner();
  }

  @Override
  public List<Video> listVideo() {
    return videoMapper.listVideo();
  }

  @Override
  public Video findDetailById(Integer videoId) {
    return videoMapper.findDetailById(videoId);
  }
}
