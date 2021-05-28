package packageName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExNumberTest {
  @ParameterizedTest
  @MethodSource
  void solve(Object expected){
    ExNumber ex = new ExNumber();
    ex.solve();
    assertEquals(expected, "actual");
  }
  static List<Arguments> solve(){
    return List.of(
      Arguments.arguments()
    );
  }
}
