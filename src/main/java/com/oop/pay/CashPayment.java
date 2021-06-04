package com.oop.pay;

import java.util.Scanner;

public class CashPayment extends Payment{
  public CashPayment(){

  }
  public CashPayment(int cost){
    super(cost);
  }
  public int getChange(int money){
    return money - this.cost;
  }
  @Override
  public void pay() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请支付现金：");
    var money = scanner.nextInt();
    var change = this.getChange(money);
    if(change < 0){
      System.out.println("现金不足！现金支付失败！");
    }else if(change == 0){
      System.out.println("支付成功！");
    }else{
      System.out.println("支付成功！需要找零"+change+"元。");
    }
    scanner.close();
  }

  public static void main(String[] args) {
    Payment p = new CashPayment(1000);
    p.pay();
  }
}
