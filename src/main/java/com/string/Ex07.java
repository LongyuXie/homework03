package com.string;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 题目描述：
 * 如果一个字符串可以由某个长度为k的字符串重复多次得到，则称该串以k为周期。
 * 例如，abcabcabcabc以3为周期（注意，它也以6和12为周期）。
 * 输入一个长度不超过80的字符串，输出其最小周期。
 * 输入界面：
 * 请输入一个字符串：abcabcabcabc
 * 输出界面：
 * 字符串：abcabcabcabc的最小周期为：3 
 */
public class Ex07 implements AbstractEx {

  private String source = "";
  public int cycle = 0;

  public Ex07(String source) {
    this.source = source;
  }

  public Ex07(){
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
    System.out.printf("字符串：%s的最小周期为：%d\n", this.source, this.cycle);
  }

  @Override
  public void solve() {
    // 如果存在周期，字符串的长度必须是合数，而且周期大小为长度的因数
    var len = this.source.length();
    for(int i = 1; i < len; i++){
      if(len % i == 0){
        if(this.source.matches("^(" + this.source.substring(0, i) + ")+$")){
          this.cycle = i;
          break;
        }
      }
    }

  }

  public static void main(String[] args) {
    new Ex07().run();
  }
}
