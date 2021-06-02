package com.string;

import com.AbstractEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 题目描述：
 * 机器人的行走的距离计算。
 * 说明：智能机器人可以接受预先输入的指令，按指令行动。
 * 机器人的基本动作很简单，只有3种：左转（记为L），右转（记为R），向前走若干厘米（直接记数字）。
 * 例如，我们可以对小车输入如下的指令：15L10R5LRR10R20
 * 则含义是：机器人先直行15厘米，左转，再走10厘米，再右转，...不难看出，对于此指令串，机器人又回到了出发地。
 * 设计一个Java程序，完成：由用户输入指令，程序输出每条指令执行后机器人位置与指令执行前机器人位置的直线距离。
 * 要求：用户先输入一个整数n（n<100），表示接下来将有n条指令。
 * 接下来输入n条指令。每条指令只由L、R和数字组成（数字是0~100之间的整数）
 * 每条指令的长度不超过256个字符。
 * 程序则输出n行结果。
 * 每条结果表示小车执行相应的指令前后位置的直线距离。要求四舍五入到小数后2位。
 */
public class Ex14 implements AbstractEx {

  private String source = "";
  public String target = "";

  public Ex14(String source) {
    this.source = source;
  }

  public Ex14(){
    super();
  }

  private static String[] ins;
  private static double[] res;
  private static int n = 0;

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    ins = new String[n];
    res = new double[n];
    for(int i = 0; i < n; i++){
      ins[i] = scanner.next();
    }
    scanner.close();
  }

  @Override
  public void output() {
    for(int i = 0; i < n; i++){
      System.out.printf("%.2f\n", res[i]);
    }
  }

  @Override
  public void solve() {
    var action = this.createAction();
    if(n > 0){
      // 处理
      for(int i = 0; i < n; i++){
        res[i] = this.calc(ins[i], action);
      }
    }
    var d = this.calc(source, action);
    this.target = String.format("%.2f", d);
  }

  public HashMap<String, String> createAction(){
    var map = new HashMap<String, String>();
    map.put("right-R", "down");
    map.put("right-L", "up");
    map.put("left-R", "up");
    map.put("left-L", "down");
    map.put("down-R", "left");
    map.put("down-L", "right");
    map.put("up-R", "right");
    map.put("up-L", "left");
    return map;
  }
  public int[] walk(String dir, int distance, int[] coor){
    switch (dir) {
      case "right":
        coor[0] += distance; 
        break;
      case "left":
        coor[0] -= distance;
        break;
      case "up":
        coor[1] += distance; 
        break;
      case "down":
        coor[1] -= distance;
        break;
      default:
        break;
    }
    return coor;
  }

  public double calc(String source, HashMap<String, String> action){

    /**
     * 坐标系格式
     * ^ y
     * |
     * |
     * ------->x
    // coor[0]表示横坐标x
    // coor[1]表示纵坐标y    */
    int[] coordinate = new int[]{0, 0};
    String reg_data = "(\\d+|R|L)";
    // 四个状态，两个操作符
    // right, left, down, up
    // 初始方向为right
    String direction = "right";


    // 首先需要确定转向规则
    // right -- R --> down
    // right -- L --> up
    // left -- R --> up
    // left -- L --> down
    // down -- R --> left
    // down -- L --> right
    // up -- R --> right
    // up -- L --> left
    // 第二步是行走规则
    // left -->  x + n
    // right --> x - n
    // down --> y - n
    // up --> y + n
    // 如何来存储以及使用这些规则？


    var matcher = Pattern.compile(reg_data).matcher(source);
    while(matcher.find()){
      var s = matcher.group(1);
      // System.out.println("s = " + s);
      if("L".equals(s) || "R".equals(s)){
        direction = action.get(direction+"-"+s);
      }else{
        walk(direction, Integer.parseInt(s), coordinate);
        // System.out.printf("(%d, %d)\n", coordinate[0], coordinate[1]);
      }
    }
  
    return Math.sqrt(coordinate[0] * coordinate[0] + coordinate[1] * coordinate[1]);
  }

  public static void main(String[] args) {
    new Ex14().run();
  }
}
