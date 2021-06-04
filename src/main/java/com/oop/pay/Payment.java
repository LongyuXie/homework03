package com.oop.pay;

/**
 * 需求：可以按任何支付方式（包括以后并把出现的支持方式）进行一定数额的支付。
 * 对任何的支持方式，可进行正确的支付。
 * 如：现金支付、信用卡支付、代金券支付、微信方式支付、支付宝方式支付、……。
 * 运用Java面向对象的知识，遵守“开-闭原则”，针对这一个软件的需求，设计一个Java的软件代码结构。
 * 设计出你的代码结构。
 */
public abstract class Payment {
  protected int cost = 0;

  public Payment(){

  }
  public Payment(int cost){
    this.cost = cost;
  }
  public int getCost() {
    return cost;
  }
  public void setCost(int cost){
    this.cost = cost;
  }

  public abstract void pay();
}
