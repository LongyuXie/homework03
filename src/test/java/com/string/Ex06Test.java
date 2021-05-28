package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex06Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, double expected){
    Ex06 ex = new Ex06(source);
    ex.solve();
    assertEquals(expected, ex.weight, 0.0000001);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("C6H5OH", 94.108),
      Arguments.arguments("C", 12.01),
      Arguments.arguments("CH", 12.01+1.008),
      Arguments.arguments("C10H", 12.01*10+1.008),
      Arguments.arguments("C4H1", 12.01*4+1.008)

    );
  }
}
