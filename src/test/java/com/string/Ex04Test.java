package com.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class Ex04Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String subString, String expected){
//    new Ex01().run();
    Ex04 ex = new Ex04(source, subString);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("aaabbbccc", "ab", "aa[ab]bbccc"),
      Arguments.arguments("ab123ab123", "ab", "[ab]123[ab]123")
    );
  }
}
