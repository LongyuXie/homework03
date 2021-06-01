package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex11Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex11 ex = new Ex11(source);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("name=王一水   sex=男   age=21   class=计算机1班", "王一水 男 21 计算机1班 "),
      Arguments.arguments("name=xielongyu sex=男 age=21 class=理科班", "xielongyu 男 21 理科班 "),
      Arguments.arguments("name = jack sex=女 age=20 class=cs", "jack 女 20 cs ")
    );
  }
}
