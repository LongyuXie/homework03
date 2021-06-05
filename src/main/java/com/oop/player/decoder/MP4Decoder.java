package com.oop.player.decoder;

public class MP4Decoder implements IDecoder {
  @Override
  public void decode(String url) {
    System.out.println("正在解码文件：" + url + ", 文件类型为：mp4");
  }
}
