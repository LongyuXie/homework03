package com.string;

import com.AbstractEx;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 题目描述：
 */
public class Ex11 implements AbstractEx {

  private String source = "";
  public String target = "";

  public Ex11(String source){
    this.source = source;
  }

  public Ex11(){
    super();
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入数据串：");
    this.source = scanner.nextLine();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("结果是：" + this.target);
  }

  @Override
  public void solve() {
    String reg_data = "([0-9a-zA-z\\u4e00-\\u9fa5]*)";
    var list = new ArrayList<String>();
    list.add("name");
    list.add("sex");
    list.add("age");
    list.add("class");
    var buffer = new StringBuffer();
    for(String s : list){
      buffer.append("\\s*")
        .append(s)
        .append("\\s*=\\s*")
        .append(reg_data);
    }
    // System.out.println(buffer.toString());
    var reg = buffer.toString();
    buffer.setLength(0);

    var matcher = Pattern.compile(reg).matcher(this.source);
    if(matcher.find()){
      // groupCount的值不包括整个正则表达式搜索的结果，除非加了括号手动分组
      // 但是group(0)总是表示整个表达式的结果
      // System.out.println("cnt = " + matcher.groupCount());
      for(int i = 1; i <= matcher.groupCount(); i++){
        buffer.append(matcher.group(i))
          .append(" ");
      }
    }

    this.target = buffer.toString();
  }

  public static void main(String[] args) {
    new Ex11().run();
  }
}
