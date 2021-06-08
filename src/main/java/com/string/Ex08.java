package com.string;

import com.AbstractEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 题目描述：
// 设有模板串如下：(注：${变量名}是定义的变量)
// "请${当前患者}患者到${诊室}等候。${等候患者}患者准备…"，
// 另外一个是数据源串如下：
// "当前患者:王一萍,诊室:一号诊室,等候患者:李芳"，
// 将数据源串中的数据值替换掉模板串中的相应变量，则结果是：
// 请王一萍患者到一号诊室等候。李芳患者准备…
// 输入界面：
// 请输入模板串：请${当前患者}患者到${诊室}等候。${等候患者}患者准备…
// 请输入数据源串：当前患者:王一萍,诊室:一号诊室,等候患者:李芳
// 输出界面：
// 结果：请王一萍患者到一号诊室等候。李芳患者准备…

public class Ex08 implements AbstractEx {

  private String templateString = "";
  private String dataString = "";
  public String result = "";

  public Ex08(){
    super();
  }

  public Ex08(String ts, String ds) {
    this.templateString = ts;
    this.dataString = ds;
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入模板字符串：");
    this.templateString = scanner.nextLine();
    System.out.print("请输入数据源字符串：");
    this.dataString = scanner.nextLine();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("结果：" + this.result);
  }

  @Override
  public void solve() {
    Pattern p = Pattern.compile("([a-zA-Z0-9_\\u4e00-\\u9fa5]+)\\s*:\\s*([a-zA-Z0-9_\u4e00-\u9fa5]+)");
    Matcher matcher = p.matcher(this.dataString);
    this.result = this.templateString;
    while(matcher.find()){
      // System.out.println("var: " + matcher.group(1));
      // System.out.println("value: " + matcher.group(2));
      this.result = this.result.replaceAll("\\$\\{" + matcher.group(1) + "}", matcher.group(2));
    }
  }

  public void replaceTemp(String s){

  }

  public static void main(String[] args) {
    new Ex08().run();
  }
}
