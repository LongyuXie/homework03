package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex05Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex05 ex = new Ex05(source);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("abcdefg", "gfedcba"),
      Arguments.arguments("输入一个字符串", "串符字个一入输"),
      Arguments.arguments("hello, world", "dlrow ,olleh"),
      Arguments.arguments("longyu xie", "eix uygnol")
    );
  }
}
