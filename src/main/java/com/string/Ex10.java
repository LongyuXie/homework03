package com.string;

import com.AbstractEx;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 题目描述：
 * 将一个字符串中的所有的单词全部翻转。
 */
public class Ex10 implements AbstractEx {
  private String source = "";
  public String target = "";
  

  public Ex10(String source) {
    this.source = source;
  }

  public Ex10(){
    super();
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入一个字符串：");
    this.source = scanner.nextLine();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("翻转结果：\"" + this.target + "\"");
  }

  @Override
  public void solve() {
    StringBuffer stringBuffer = new StringBuffer();
    var p = Pattern.compile("[a-zA-Z]+");
    var matcher = p.matcher(this.source);
    int lastEnd = 0;
    while(matcher.find()){
      int start = matcher.start();
      int end = matcher.end();
      if(start != 0){
        stringBuffer.append(this.source.subSequence(lastEnd, start));
      }
      stringBuffer.append(
        new StringBuffer(matcher.group()).reverse().toString()
      );
      lastEnd = end;
    }
    if(lastEnd != this.source.length()){
      stringBuffer.append(this.source.substring(lastEnd));
    }
    this.target = stringBuffer.toString();
  }

  public static void main(String[] args) {
    new Ex10().run();
  }
}
