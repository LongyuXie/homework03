package com.string;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 题目描述：将一个字符串转置后返回。
 * 输入界面：
 * 请输入一个字符串：abc123汉字
 * 输出界面：
 * 结果是：字汉321cba
 */
public class Ex05 implements AbstractEx {

  private String source = "";
  public String target = "";

  public Ex05(String source){
    this.source = source;
  }

  public Ex05(){
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
    System.out.println("结果是：" + this.target);
  }

  @Override
  public void solve() {
    StringBuffer buffer = new StringBuffer(this.source);
    this.target = buffer.reverse().toString();
  }

  public static void main(String[] args) {
    new Ex05().run();
  }
}
