package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex09Test {
  @ParameterizedTest
  @MethodSource
  void solve(String rc, String expected){
    Ex09 ex = new Ex09(rc);
    ex.solve();
    assertEquals(expected, ex.regular);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("R12C4", "D12"),
      Arguments.arguments("R5C255", "IU5")
    );
  }
}
