package com.string;

import com.AbstractEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题目描述：
 * Excel中，实现从RC地址格式到常规地址格式的转换。
 */
public class Ex09 implements AbstractEx {

  private String rc = "";
  public String regular = "";


  public Ex09(String rc) {
    this.rc = rc;
  }

  public Ex09(){
    super();
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    this.rc = scanner.next();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println(this.rc + " ---> " + this.regular);
  }

  @Override
  public void solve() {
    Pattern p  = Pattern.compile("R(\\d+)C(\\d+)");
    Matcher matcher = p.matcher(this.rc.toUpperCase());
    if(matcher.find()){
      int row = Integer.parseInt(matcher.group(1));
      int col = Integer.parseInt(matcher.group(2));
      var buffer = new StringBuffer();
      var mybase = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
      while(col != 0){
        var a = col % 26;
        if(a == 0){
          a = 26;
        }
        buffer.append(mybase.charAt(a-1));
        col = (col - a) / 26;
      }
      this.regular = buffer.reverse()
        .append(row)
        .toString();
    }
  }

  public static void main(String[] args) {
    new Ex09().run();
  }
}
