package com.oop.player;

import com.oop.player.decoder.IDecoder;

/**
 * 第5题 ：跨平台视频播放器的结构设计。
 * 一个视频文件有多种类型如：MPEGFile、RMVBFile、AVIFile、WMVFile等等(还会不断有新的文件类型出来)。
 * 该视频播放器可在：Windows操作系统、Unix操作系统、Linux操作系统等（还会加入新的支持的操作系统）上正常播放。
 * 每一个具体的操作系统平台上，播放每一个视频的实现代码是不同的（这是操作系统相关的）。
 * 请你运用Java面向对象的知识，遵守“开-闭原则”，
 * 设计这样一个通用的视频播放器的结构， 使得以后能方便扩充新的视频文件和新的操作系统平台。
 */
public interface IPlayer {
  void setDecoder(IDecoder decoder);

  void play(String url);
}
