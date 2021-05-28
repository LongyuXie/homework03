package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex07Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, int expected){
    Ex07 ex = new Ex07(source);
    ex.solve();
    assertEquals(expected, ex.cycle);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("aaaaa", 1),
      Arguments.arguments("ababcababc", 5),
      Arguments.arguments("abcabcabcabc", 3),
      Arguments.arguments("aabb", 0),
      Arguments.arguments("a", 0),
      Arguments.arguments("aa", 1),
      Arguments.arguments("abcabc", 3)
    );
  }
}
