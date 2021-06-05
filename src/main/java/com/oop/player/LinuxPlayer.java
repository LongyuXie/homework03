package com.oop.player;

import com.oop.player.decoder.IDecoder;

public class LinuxPlayer implements IPlayer {
  private IDecoder fileDecoder;

  @Override
  public void setDecoder(IDecoder decoder) {
    this.fileDecoder = decoder;
  }

  @Override
  public void play(String url) {
    System.out.println("操作系统是：Linux");
    this.fileDecoder.decode(url);
  }
}
