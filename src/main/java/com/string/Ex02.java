package com.string;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 将多个相同的连续字符合并为1个字符
 * aaabbbccc -> abc
 */
public class Ex02 implements AbstractEx {
  public Ex02(String source) {
    this.source = source;
  }
  public Ex02(){

  }

  String source = "";
  String target = "";

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入字符串");
    this.source = scanner.nextLine();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("压缩结果是：" + this.target);
  }

  @Override
  public void solve() {
//    this.target = source.replaceAll();
    this.target = Ex02.compress(this.source);
  }

  /**
   * 将多个连续相同的字符压缩为1个字符
   * eg: aaabbbbccc -> abc
   * @param source
   * @return
   */
  public static String compress(String source){
    if(source == null || source.isEmpty()){
      return source;
    }
    StringBuffer buffer = new StringBuffer();
    int len = source.length();
    char c = source.charAt(0);
    buffer.append(c);
    for (int i = 1; i < len; i++){
      if(c != source.charAt(i)){
        buffer.append(source.charAt(i));
        c = source.charAt(i);
      }
    }
    return buffer.toString();
  }

  public static void main(String[] args) {
    new Ex02().run();
  }
}
