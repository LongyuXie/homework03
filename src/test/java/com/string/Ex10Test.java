package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex10Test {
  @ParameterizedTest
  @MethodSource
  void solve(String source, String expected){
    Ex10 ex = new Ex10(source);
    ex.solve();
    assertEquals(expected, ex.target);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments("To676767Be     or 878 not()() to &**^be", "oT676767eB     ro 878 ton()() ot &**^eb"),
      Arguments.arguments("hello, world! Longyu Xie.", "olleh, dlrow! uygnoL eiX."),
      Arguments.arguments("To  be  or  not  to  be!", "oT  eb  ro  ton  ot  eb!")
    );
  }
}
