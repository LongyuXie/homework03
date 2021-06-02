package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex13Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex13 ex = new Ex13(source);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("aaabbbbbcddf", "a3b5cd2f"),
      Arguments.arguments("aaaagbbbaaccc", "a4gb3a2c3")
    );
  }
}
