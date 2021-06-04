package com.oop.pay;

import java.util.Scanner;

public class CreditPayment extends Payment{
  private String cardID;
  CreditPayment(int cost, String cardID){
    super(cost);
    this.cardID = cardID;
  }
  CreditPayment(){
    super();
  }

  @Override
  public void pay() {
    Scanner scanner = new Scanner(System.in);
    if(this.cardID == null){
      System.out.print("请输入信用卡卡号：");
      var id = scanner.next();
      this.setCardID(id);
    }
    System.out.println("信用卡卡号为：" + this.cardID);
    System.out.print("请输入密码：");
    var password = scanner.next();
    boolean result = this.auth(this.cardID, password);
    System.out.println("信用卡支付" + (result ? "成功" : "失败"));
  }

  public String getCardID() {
    return cardID;
  }

  public boolean auth(String cardID, String password){
    if(cardID.matches("\\d{10}") && "123456".equals(password)){
      System.out.println("支付授权成功！");
      return true;
    }else{
      System.out.println("支付授权失败");
      return false;
    }
  }

  public void setCardID(String cardID) {
    this.cardID = cardID;
  }

  public static void main(String[] args) {
    Payment p = new CreditPayment();
    p.setCost(1000);
    p.pay();
  }
}
