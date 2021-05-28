package com.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex08Test {
  @ParameterizedTest
  @MethodSource
  void solve(String ts, String ds, String expected){
    Ex08 ex = new Ex08(ts, ds);
    ex.solve();
    assertEquals(expected, ex.result);
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments(
        "请${当前患者}患者到${诊室}等候。${等候患者}患者准备...",
        "当前患者:王一萍,诊室:一号诊室,等候患者:李芳",
        "请王一萍患者到一号诊室等候。李芳患者准备..."
      ),
      Arguments.arguments(
        "${用户名}的${银行}银行的账户余额为${余额}元",
        "用户名:谢龙玉,银行:浦发,余额:1000",
        "谢龙玉的浦发银行的账户余额为1000元"
      ),
      Arguments.arguments(
        "hello, world! ${username}! current user is ${username}.",
        "username:谢龙玉",
        "hello, world! 谢龙玉! current user is 谢龙玉."
      )
    );
  }
}
