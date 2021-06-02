package com.string;

import com.AbstractEx;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 题目描述：
 * 字符串的压缩编码。
 * 如：字符串："aaaagbbbaaccc"压缩后的结果是："a4gb3a2c3"
 * 即：每一个字符后跟它连续重复的次数。如：aaaa压缩成：a4。注意只有一个，则保持不变。
 * 如上例中的字符g
 */
public class Ex13 implements AbstractEx {
  private String source = "";
  public String target = "";

  public Ex13(String source) {
    this.source = source;
  }

  public Ex13(){
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
    System.out.println("压缩后的结果是：" + this.target);
  }

  @Override
  public void solve() {
    // '\1'表示的是捕获的第一组的数据
    String reg_data = "([a-zA-Z0-9])\\1*";
    var matcher = Pattern.compile(reg_data).matcher(this.source);
    var buffer = new StringBuffer();
    while(matcher.find()){
      var s = matcher.group();
      if(s.length() == 1){
        buffer.append(s);
      }else{
        buffer.append(s.charAt(0))
              .append(s.length());
      }
    }
    this.target = buffer.toString();
  }

  public static void main(String[] args) {
    new Ex13().run();
  }
}
