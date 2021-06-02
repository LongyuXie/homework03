package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex14Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex14 ex = new Ex14(source);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("L100R50R10", "102.96"),
      Arguments.arguments("3LLL5RR4L12", "9.06"),
      Arguments.arguments("LL", "0.00"),
      Arguments.arguments("100R", "100.00"),
      Arguments.arguments("5L5L5L5", "0.00")
    );
  }
}
