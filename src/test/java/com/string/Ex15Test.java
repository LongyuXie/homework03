package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex15Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex15 ex = new Ex15(source);
    ex.solve();
    assertEquals(expected, ex.password);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("zhangfeng", "772243"),
      Arguments.arguments("wangximing", "344836"),
      Arguments.arguments("jiujingfazi", "297332"),
      Arguments.arguments("woaibeijingtiananmen", "716652"),
      Arguments.arguments("haohaoxuexi", "875843")
    );
  }
}
