package com.string;

import com.AbstractEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题目描述：给出一种物质的分子式（不带括号），求分子量
 * 本题中的分子式只包含4种原子，分别为C, H, O, N，原子量分别为12.01, 1.008, 16.00, 14.01（单位：g/mol）。
 * 输入界面：
 * 请输入分子式：C6H5OH 
 * 输出界面：
 * 分子式：C6H5OH的分子量为94.108g/mol。
 */
public class Ex06 implements AbstractEx {

  private String source = "";
  public double weight = .0;
  private Map<Character, Double> weightMap = new HashMap<Character, Double>(){{
    put('C', 12.01);
    put('H', 1.008);
    put('O', 16.00);
    put('N', 14.01);
  }};

  public Ex06(String source) {
    this.source = source;
  }

  public Ex06(){
    super();
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入分子式：");
    this.source = scanner.next();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.printf("分子式：%s的分子量为%fg/mol\n", this.source, this.weight);
  }

  @Override
  public void solve() {
    // 每一个字母后接若干个数字
    Pattern p = Pattern.compile("[CHON]\\d*");
    Matcher matcher = p.matcher(this.source.toUpperCase());
    while(matcher.find()){
      var s = matcher.group();
      if(s.length() == 1){
        this.weight += this.weightMap.get(s.charAt(0));
      }else{
        this.weight += this.weightMap.get(s.charAt(0)) * Integer.parseInt(s.substring(1));
      }
    }
  }


  // @Override
  public void calc() {
    char c   = 0;
    int  num = 0;

    int len = this.source.length();

    StringBuffer buffer = new StringBuffer();

    for(int i = 0; i < len; ){
      if(c != 0 && num != 0){
        this.weight += this.weightMap.get(c) * num;
        c = 0;
        num = 0;
      }else if(c == 0){
        c = this.source.charAt(i);
        i++;
      }else{
        var d = this.source.charAt(i);
        if(Character.isDigit(d)){
          buffer.append(d);
          i++;
        }else{
          num = (buffer.length() == 0) ? 1 : Integer.parseInt(buffer.toString());
          buffer.setLength(0);
        }
       }
    }
    if(c != 0){
      this.weight += this.weightMap.get(c) * ((buffer.length() == 0) ? 1 : Integer.parseInt(buffer.toString()));
    }

  }

  public static void main(String[] args) {
    new Ex06().run();
  }
}
