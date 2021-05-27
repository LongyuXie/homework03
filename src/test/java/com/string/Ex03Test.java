package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex03Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, int sum){
//    new Ex01().run();
    Ex03 ex = new Ex03(source);
    ex.solve();
    assertEquals(ex.sum, sum);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("aaabbbccc", 0),
      Arguments.arguments("aaabbcddd112233((55))", 112233+55),
      Arguments.arguments("11afeaw13b4", 11+13+4)
    );
  }
}