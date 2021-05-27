package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex01Test {
  @ParameterizedTest
  @MethodSource
  void solve(int k, int m, String num, boolean suc, String target){
//    new Ex01().run();
    Ex01 ex = new Ex01(k, m, num);
    ex.solve();
    assertEquals(ex.success, suc);
    assertEquals(ex.target, target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments(3, 5, "102", true, "21"),
      Arguments.arguments(3, 5, "104", false, "")
    );
  }
}