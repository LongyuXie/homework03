package packageName;

import com.AbstractEx;

import java.util.Scanner;

/**
 * 题目描述：
 */
public class ExNumber implements AbstractEx {

  public ExNumber(){
    super();
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);

    scanner.close();
  }

  @Override
  public void output() {

  }

  @Override
  public void solve() {

  }

  public static void main(String[] args) {
    new ExNumber().run();
  }
}
