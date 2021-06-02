package com.string;

import com.AbstractEx;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述：
 * 帐号密码加密处理。
 * 说明：
 * 在对银行账户等重要权限设置密码的时候，常常遇到这样的烦恼：
 *  - 如果为了好记用生日吧，容易被破解，不安全；
 *  - 如果设置不好记的密码，又担心自己也会忘记；
 *  - 如果写在纸上，担心纸张被别人发现或弄丢了...
 * 该程序的功能是把一串拼音字母转换为6位数字（密码）。
 * 可以使用任何好记的拼音串(比如名字，王喜明，就写：wangximing)作为输入，程序输出6位数字。
 * 变换的过程如下：
 * 第一步. 把字符串6个一组折叠起来，比如wangximing则变为：
 * wangxi
 * ming 
 * 第二步. 把所有垂直在同一个位置的字符的ascii码值相加，得出6个数字，如上面的例子，则得出：
 * 228 202 220 206 120 105
 * 第三步. 再把每个数字“缩位”处理：
 * 就是把每个位的数字相加，得出的数字如果不是一位数字，就再缩位，直到变成一位数字为止。例如: 228 => 2+2+8=12 => 1+2=3
 * 6个数字连接形成密码串
 */
public class Ex15 implements AbstractEx {
  private String source = "";
  public String password = "000000";

  public Ex15(String source) {
    this.source = source;
  }

  public Ex15(){
    super();
  }

  // 输入限制：拼音串 -> regx: "[a-z]+"
  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    this.source = scanner.next();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println(this.password);
  }

  @Override
  public void solve() {
    // 1. 每6个字符分为一组
    int len = this.source.length();
    var buffer = new StringBuffer(this.source.toLowerCase());
    int numbers = 6;
    if(len % numbers != 0){
      buffer.append("\0".repeat(numbers-len%numbers));
    }
    var s = buffer.toString();
    // System.out.println("s.length = " + s.length());
    var list = new ArrayList<String>();
    for(int i = 0; i < len; i += numbers){
      list.add(s.substring(i, i+numbers));
      // System.out.println("list-" + i + " = " + list.get(list.size()-1));
    }
    // 2. 计算在同一个位置的字符ascii码值的和
    int[] digits = new int[numbers];
    for(int i = 0; i < numbers; i++){
      digits[i] = 0;
      for(int j = 0; j < list.size(); j++){
        digits[i] += (int)list.get(j).charAt(i);
      }
      // System.out.println("digits-" + i + " = " + digits[i]);
    }
    buffer.setLength(0);
    // 3. 缩位处理
    for(int i = 0; i < numbers; i++){
      buffer.append(this.compress(digits[i]));
    }
    this.password = buffer.toString();
  }
  /**
   * 确保n不能小于0
   * @param n n > 0
   * @return
   */
  private int compress(int n){
    if(n < 0){
      return 0;
    }
    while(n >= 10){
      n = digitSum(n);
    }
    return n;
  }
  private int digitSum(int n){
    int sum = 0;
    while(n != 0){
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    new Ex15().run();
  }
}
