package com.string;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 从字符串中提取整数，并求和
 */
public class Ex03 implements AbstractEx {
  public Ex03(){

  }
  public Ex03(String source){
    this.source = source;
  }

  private String source = "";
  public int sum = 0;

  @Override
  public void input() {
    System.out.print("请输入一个字符串：");
    Scanner scanner = new Scanner(System.in);
    this.source = scanner.next();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("sum = " + this.sum);
  }

  @Override
  public void solve() {
    String[] nums = this.source.split("[^0-9]+");
    int sum = 0;
    for (String n : nums){
      if(!n.isEmpty()){
        sum += Integer.parseInt(n);
      }
    }
    this.sum = sum;
  }

  public static void main(String[] args){
    new Ex03().run();
  }
}
