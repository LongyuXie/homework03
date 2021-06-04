package com.oop.sort;

import java.util.HashMap;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    var p = new GUIProgram();
    p.setData(new int[]{4, 1, 0, 9, 10, 8, 7, 1, 2});
    var data = p.getData();
    System.out.println("原始数组为：");
    for (int n : data) {
      System.out.printf("%d ", n);
    }
    System.out.println();
    String opt;
    var map = new HashMap<String, ISort>();
    map.put("select", new SelectSort());
    map.put("insert", new InsertSort());
    map.put("bubble", new BubbleSort());
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("请输入排序的方式(select, bubble, insert)或者输入quit退出：");
      opt = scanner.next();
      if ("quit".equals(opt)) {
        break;
      }
      var sortStrategy = map.get(opt);
      if (sortStrategy != null) {
        p.setSortStrategy(sortStrategy);
        p.sort();
        p.printResult();
      } else {
        System.out.println("没有对应的排序方式，请重新输入！");
      }
    }
    scanner.close();
  }
}
