package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String target){
//    new Ex01().run();
    Ex02 ex = new Ex02(source);
    ex.solve();
    assertEquals(ex.target, target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("aaabbbccc", "abc"),
      Arguments.arguments("aaabbcddd112233((55))", "abcd123(5)")
    );
  }
}