package com.string;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 将k进制的数字字符串转换为m进制
 */
public class Ex01 implements AbstractEx {
  public Ex01(int k, int m, String num) {
    this.k = k;
    this.m = m;
    this.num = num;
  }
  public Ex01(){
    super();
  }

  private int k = 10;
  private int m = 10;
  private String num = "0";
  public boolean success = false;
  public String target = "";

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入原进制：");
    k = scanner.nextInt();
    System.out.print("该进制的数字串：");
    num = scanner.nextLine();
    System.out.print("请输入目标进制：");
    m = scanner.nextInt();
    scanner.close();
  }

  @Override
  public void output() {
    if (success) {
      System.out.printf("%d进制数%s转换成%d进制结果是：%s", k, num, m, target);
    } else {
      System.out.printf("%s是非法的%d进制数！", num, k);
    }
  }

  @Override
  public void solve() {
    try {
      int num_10 = Integer.parseInt(num, k);
      target = Integer.toString(num_10, m);
      success = true;
    } catch (NumberFormatException e) {
      success = false;
    }
  }

  public static void main(String[] args) {
    new Ex01().run();
  }
}