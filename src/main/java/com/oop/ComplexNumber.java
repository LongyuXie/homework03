package com.oop;

/**
 * 复数由实部与虚部两部分组成，如：3+2i。假设复数的实况与虚部都是double类型。
 * 两个复数可以进行相加、减、乘运算。可以按：3.2+2.6i或3.2-1.5i或0.5i或1.5格式转换成字符串格式。
 * 复数是一个常对象，即：进行运算时不影响原来的两个复数对象。
 * 请按以上需求，用Java面向对象的知识，进行该Java代码的结构设计。
 */
public class ComplexNumber {
  private final double real;
  private final double imaginary;

  public ComplexNumber(){
    this.real = 0;
    this.imaginary = 0;
  }
  public ComplexNumber(double r, double i){
    this.real = r;
    this.imaginary = i;
  }

  @Override
  public String toString() {
    // TODO：浮点数的比较可能出现问题
    return this.real == 0 ? this.imaginary + "i" : this.real + ((this.imaginary < 0) ? "-" : "+") + Math.abs(this.imaginary) + "i";
  }
}
