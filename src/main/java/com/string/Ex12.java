package com.string;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 题目描述： 表达式整理，去掉多余的括号。 假设输入的表达式是正确的（不用检验是否正确），且只是由+和*两种运算组成。
 * 如："(((2))*(((4+1))))+2"，去掉多余括号后，结果是："2*(4+1)+2" 
 * 什么是多余的括号？哪些括号不多余？ 
 * ((expr)) -> (expr) 
 * +(expr)+ -> +expr+ 
 * (expr*expr) -> expr*expr 
 * 不适合正则表达式
 * 
 */
public class Ex12 implements AbstractEx {

  private String source = "";
  public String target = "";

  public Ex12(String source) {
    this.source = source;
  }

  public Ex12() {
    super();
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入一个正确的表达式：");
    this.source = scanner.nextLine();
    scanner.close();
  }

  @Override
  public void output() {
    System.out.println("去除括号后：" + this.target);
  }

  @Override
  public void solve() {
    // 如果表达式正确
    // 那么对于每一个左括号都有匹配的邮括号
    // 每一个运算符的两边都有一个表达式
    // 括号的数量是匹配的
    // 表达式中没有多余的空格
    this.target = removeBrackets(this.source);
  }

  private String removeBrackets(String source) {
    var arr = source.toCharArray();
    int[] cache = new int[arr.length];
    this.removeBrackets(arr, 0, cache);
    return new String(arr).replaceAll("\\s+", "");
  }

  private int removeBrackets(char[] expr, int left, int[] cache) {
    for (int i = left; i < expr.length; i++) {
      if (expr[i] == ')') {
        return i;
      } else if (expr[i] == '(') {
        int newLeft = i;
        int newRight = removeBrackets(expr, newLeft + 1, cache);
        if (newRight == expr.length) {
          break;
        }
        if (this.checkToRemove(expr, newLeft, newRight, cache)) {
          expr[newLeft] = expr[newRight] = ' ';
        }else{
          cache[newLeft] = newRight;
        }
        i = newRight;
      }
      // System.out.println(new String(expr).replaceAll("\\s+", ""));
      // System.out.println(new String(expr));
      // System.out.println(" ".repeat(i) + i);
    }
    return expr.length;
  }

  private boolean checkToRemove(char[] expr, int left, int right, int[] cache) {
    char leftChar = '+';
    char rightChar = '+';
    boolean hasAdd = false;
    // 函数的参数表示括号表达式的位置，left和right是左括号和右括号的位置
    for (int i = left+1; i <= right-1; i++) {
      if (expr[i] == '+') {
        hasAdd = true;
        break;
      }else if(expr[i] == '('){
        // 只考虑最顶层的表达式是否有加号，
        // eg: ((a+b)*c+d)，在这个表达式中只有"+d"中的加号才决定是否有加法
        // 可以记录每个保留的括号表达式的位置和长度，这样可以减少遍历的次数
        // 一个比较好的映射：左括号的位置 -> 右括号位置
        // 如何保存呢！在哪里保存！如何传递缓存数据！
        i = cache[i];
        // int level = 1;
        // while(level != 0){
        //   i++;
        //   if(expr[i] == '('){
        //     level++;
        //   }else if(expr[i] == ')'){
        //     level--;
        //   }
        // }
      }
    }
    // System.out.println("hasAdd = " + hasAdd);
    // 考虑边界情况，要求最初的表达式已经去除了空格
    // 如果整个表达式被括号括起来，eg: (a+b)，也需要去除括号
    // 去括号的过程总是从内层括号向外层括号
    if (left != 0) {
      leftChar = expr[left - 1];
    }
    if (right != expr.length - 1) {
      rightChar = expr[right + 1];
    }

    boolean ans = false;
    switch (leftChar) {
      case '(':
        if (rightChar == ')') {
          ans = true;
          break;
        }
      case '+':
        if (rightChar == '+' || rightChar == ')') {
          ans = true;
        } else if (rightChar == '*') {
          ans = (!hasAdd);
        }
        break;
      case '*':
      // 如果括号表达式的左边是是一个乘法，那么只有当表达式中没有加法时才可以去除括号
        ans = !hasAdd;
        break;
      default:
        break;
    }
    return ans;
  }
  public static void main(String[] args) {
    new Ex12().run();
  }
}
