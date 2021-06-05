package com.oop.player;

import com.oop.player.decoder.AVGDecoder;

public class Client {
  public static void main(String[] args) {
    var player = new LinuxPlayer();
    var avgDecoder = new AVGDecoder();
    player.setDecoder(avgDecoder);
    player.play("hello.avg");
  }
}
