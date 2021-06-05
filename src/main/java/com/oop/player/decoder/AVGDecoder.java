package com.oop.player.decoder;

public class AVGDecoder implements IDecoder {
  @Override
  public void decode(String url) {
    System.out.println("正在解码文件：" + url + ", 文件类型为：avg");
  }
}
