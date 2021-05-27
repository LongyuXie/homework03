package com.string;

import java.util.Scanner;

import com.AbstractEx;

/**
 * 将一个字符串中出现的子串两边加上方括号
 * eg：
 * 输入：
 * 原始字符串为：ab123ab123565
 * 子串：ab
 * 输出：[ab]123[ab]123565
 */
public class Ex04 implements AbstractEx{

  private String source = "";
  private String subStr = "";
  public  String target = "";


  public Ex04() {
  }

  public Ex04(String source, String subStr) {
    this.source = source;
    this.subStr = subStr;
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入一个字符串：");
    this.source = scanner.next();
    System.out.print("请输入作为字串的字符串：");
    this.subStr = scanner.next();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("结果是：" + this.target);
  }

  @Override
  public void solve() {
    this.target = this.source.replaceAll(this.subStr, "[$0]");
  }

}
