package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex12Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex12 ex = new Ex12(source);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("(((2))*(((4+1))))+2", "2*(4+1)+2"),
      Arguments.arguments("(((2))+(((4+1))))+2", "2+4+1+2"),
      Arguments.arguments("(((2))+(((4*1))))+2", "2+4*1+2"),
      Arguments.arguments("(((2))*(((4*1))))+2", "2*4*1+2")
    );
  }
}
