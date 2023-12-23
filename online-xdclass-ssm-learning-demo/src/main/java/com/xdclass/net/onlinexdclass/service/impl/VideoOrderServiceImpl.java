package com.xdclass.net.onlinexdclass.service.impl;

import com.xdclass.net.onlinexdclass.entity.Episode;
import com.xdclass.net.onlinexdclass.entity.PlayRecord;
import com.xdclass.net.onlinexdclass.entity.Video;
import com.xdclass.net.onlinexdclass.entity.VideoOrder;
import com.xdclass.net.onlinexdclass.exception.XDException;
import com.xdclass.net.onlinexdclass.mapper.EpisodeMapper;
import com.xdclass.net.onlinexdclass.mapper.PlayRecordMapper;
import com.xdclass.net.onlinexdclass.mapper.VideoMapper;
import com.xdclass.net.onlinexdclass.mapper.VideoOrderMapper;
import com.xdclass.net.onlinexdclass.service.VideoOrderService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 视频订单服务实现
 * @author: Joker.yu 2023-12-23 14:55
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {

  @Autowired private VideoOrderMapper videoOrderMapper;

  @Autowired private VideoMapper videoMapper;

  @Autowired private EpisodeMapper episodeMapper;

  @Autowired private PlayRecordMapper playRecordMapper;

  @Override
  @Transactional
  public void placeOrder(Integer videoId, Integer userId) {
    Optional<VideoOrder> videoOrderOptional =
        Optional.ofNullable(videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1));
    if (videoOrderOptional.isPresent()) {
      throw new XDException(-1, "订单已存在，下单失败!");
    }
    Video video = videoMapper.findDetailById(videoId);
    if (Objects.isNull(video)) {
      throw new XDException(-1, "当前视频不存在，请运营人员检查!");
    }
    int saveOrderRows = videoOrderMapper.saveOrder(builderVideoOrder(userId, video));
    // 生成播放记录
    if (saveOrderRows == 1) {
      Optional.ofNullable(episodeMapper.findFirstEpisodeByVideoId(videoId))
          .map(
              episode -> {
                PlayRecord playRecord = new PlayRecord();
                playRecord.setCreateTime(new Date());
                playRecord.setEpisodeId(episode.getId());
                playRecord.setCurrentNum(episode.getNum());
                playRecord.setUserId(userId);
                playRecord.setVideoId(videoId);
                playRecordMapper.saveRecord(playRecord);
                return episode;
              })
          .orElseThrow(() -> new XDException(-1, "视频没有集信息，请运营人员检查"));
    }
  }

  @Override
  public List<VideoOrder> listOrderByUserId(Integer userId) {
    return videoOrderMapper.listOrderByUserId(userId);
  }

  /**
   * 构建视频订单
   *
   * @param userId 用户id
   * @param existedVideo 查询到的视频
   * @return 视频订单
   */
  private VideoOrder builderVideoOrder(Integer userId, Video existedVideo) {
    VideoOrder videoOrder = new VideoOrder();
    videoOrder.setCreateTime(new Date());
    videoOrder.setOutTradeNo(UUID.randomUUID().toString());
    videoOrder.setState(1);
    videoOrder.setTotalFee(existedVideo.getPrice());
    videoOrder.setUserId(userId);
    videoOrder.setVideoId(existedVideo.getId());
    videoOrder.setVideoImg(existedVideo.getCoverImg());
    videoOrder.setVideoTitle(existedVideo.getTitle());
    return videoOrder;
  }
}
