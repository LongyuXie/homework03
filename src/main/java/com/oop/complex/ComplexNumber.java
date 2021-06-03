package com.oop.complex;

import com.exception.ComplexNumberException;

import java.util.regex.Pattern;

/**
 * 复数由实部与虚部两部分组成，如：3+2i。假设复数的实况与虚部都是double类型。
 * 两个复数可以进行相加、减、乘运算。可以按：3.2+2.6i或3.2-1.5i或0.5i或1.5格式转换成字符串格式。
 * 复数是一个常对象，即：进行运算时不影响原来的两个复数对象。
 * 请按以上需求，用Java面向对象的知识，进行该Java代码的结构设计。
 *
 * 所有的浮点数相等判断都应该转换为
 * (a - b) < delta = 1e10
 * delta是能接受的误差值
 */
public class ComplexNumber {
  private final double real;
  private final double imaginary;

  public double getReal() {
    return real;
  }

  public double getImaginary() {
    return imaginary;
  }

  /**
   * 从字符串中解析复数
   * 什么样的字符串是合格的字符串
   * @param s
   */
  public static ComplexNumber parseComplexNumber(String s){
    if(s == null || s.length() == 0){
      return null;
    }
    ComplexNumber c = null;
    double real;
    double imaginary;

    try {
      if(s.charAt(s.length()-1) != 'i'){
        // 判断是否是纯实数
        real = Double.parseDouble(s);
        c = new ComplexNumber(real, 0);
      }else{
        // 判断是否是纯虚数: 1.0i
        imaginary = Double.parseDouble(s.substring(0, s.length()-1));
        c = new ComplexNumber(0, imaginary);
      }
    }catch (NumberFormatException e){
//      e.printStackTrace();
    }

    if(c != null){
      return c;
    }

    String reg = "^([+-]?\\d*\\.?\\d+)?([+-]\\d*\\.?\\d+)i$";
    var matcher = Pattern.compile(reg).matcher(s);
    if(matcher.find()){
      String sr = matcher.group(1);
      String si = matcher.group(2);
      try {
        real =  Double.parseDouble(sr);
        imaginary = Double.parseDouble(si);
        c = new ComplexNumber(real, imaginary);
      }catch (NumberFormatException e){
//        e.printStackTrace();
      }
    }
    return c;
  }

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
    // TODO：浮点数的相等性比较
    if (this.imaginary == 0) return this.real + "";
    if (this.real == 0) return this.imaginary + "i";
    return this.real + ((this.imaginary < 0) ? "-" : "+") + Math.abs(this.imaginary) + "i";
  }

  public ComplexNumber add(ComplexNumber c){
    if(c == null){
      throw new ComplexNumberException("ComplexNumber.add(c): argument could not be null");
    }
    return new ComplexNumber(c.real+this.real, c.imaginary+this.imaginary);
  }
  public ComplexNumber sub(ComplexNumber c){
    if(c == null){
      throw new ComplexNumberException("ComplexNumber.sub(c): argument could not be null");
    }
    return new ComplexNumber(this.real-c.real, this.imaginary-c.imaginary);
  }

  /**
   * 复数的乘法运算 c = a * b的运算法则是：
   * c.实部 = a.实部 * b.实部 - a.虚部 * b.虚部
   * c.虚部 = a.虚部 * b.实部 + a.实部 * b.虚部
   */
  public ComplexNumber mul(ComplexNumber c){
    if(c == null){
      throw new ComplexNumberException("ComplexNumber.mul(c): argument could not be null");
    }
    double newReal = this.real*c.real-this.imaginary*c.imaginary;
    double newImaginary = this.real*c.imaginary+this.imaginary*c.real;
    return new ComplexNumber(newReal, newImaginary);
  }

  /**
   * 复数的除法运算 c = a / b 的运算法则是：
   * c.实部 = (a.实部 * b.实部 + a.虚部 * b.虚部) / (b.实部* b.实部 + b.虚部 * b.虚部)
   * c.虚部 = (a.虚部 * b.实部 - a.实部 * b.虚部) / (b.实部 * b.实部 + b.虚部 * b.虚部)
   */
  public ComplexNumber div(ComplexNumber c){
    if(c == null){
      throw new ComplexNumberException("ComplexNumber.div(c): argument cannot be null");
    }
    double denominator = c.real*c.real + c.imaginary*c.imaginary;
    if(denominator == 0){
      throw new ComplexNumberException("ComplexNumber.div(c): divisor cannot be 0");
    }
    double newReal = (this.real*c.real+this.imaginary*c.imaginary) / denominator;
    double newImaginary = (this.imaginary*c.real-this.real*c.imaginary) / denominator;
    return new ComplexNumber(newReal, newImaginary);
  }

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null){
      return false;
    }
    if(obj instanceof ComplexNumber){
      ComplexNumber c = (ComplexNumber) obj;
      // TODO: 浮点数相等性判断
      return c.real == this.real && c.imaginary == this.imaginary;
    }
    return false;
  }
}
