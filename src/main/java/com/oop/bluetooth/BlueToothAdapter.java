package com.oop.bluetooth;

public class BlueToothAdapter {
  private static final BlueToothAdapter instance = new BlueToothAdapter();

  private BlueToothAdapter() {
    System.out.println("创建了一个蓝牙适配器");
  }

  public static BlueToothAdapter getInstance() {
    return BlueToothAdapter.instance;
  }

  /**
   * 在类的内部可以调用构造函数
   * 私有修饰词private只能基于类层次隐藏成员，而不是基于对象
   */
  public static void main(String[] args) {
    var blueToothAdapter1 = BlueToothAdapter.getInstance();
    var blueToothAdapter2 = BlueToothAdapter.getInstance();
    System.out.println(blueToothAdapter1.equals(blueToothAdapter2));
  }
}
