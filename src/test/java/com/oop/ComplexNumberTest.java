package com.oop;

import com.exception.ComplexNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

  @Test
  void parseComplexNumber() {
    assertNull(ComplexNumber.parseComplexNumber(""));
    assertNull(ComplexNumber.parseComplexNumber(null));

    assertNull(ComplexNumber.parseComplexNumber("ka"));
    assertNull(ComplexNumber.parseComplexNumber("ki"));
    assertEquals("4.56", ComplexNumber.parseComplexNumber("4.56").toString());

    assertEquals("4.56i", ComplexNumber.parseComplexNumber("4.56i").toString());
    assertEquals("-4.56i", ComplexNumber.parseComplexNumber("-4.56i").toString());
    assertEquals("4.56i", ComplexNumber.parseComplexNumber("+4.56i").toString());

    assertEquals("1.0+4.56i", ComplexNumber.parseComplexNumber("1+4.56i").toString());
    assertEquals("-1.0-4.56i", ComplexNumber.parseComplexNumber("-1.000-4.56i").toString());

    assertNull(ComplexNumber.parseComplexNumber("32+abci"));
  }

  @Test
  void testToString() {
    assertEquals("1.0i", new ComplexNumber(0, 1.0).toString());
    assertEquals("1.0i", new ComplexNumber(0, 1).toString());
    assertEquals("3.0+1.321i", new ComplexNumber(3, 1.321).toString());
    assertEquals("-3.0-1.1i", new ComplexNumber(-3, -1.1).toString());
    assertEquals("-3.0i", new ComplexNumber(0, -3).toString());
    assertEquals("0.0", new ComplexNumber(0, 0).toString());
    assertEquals("-4.122", new ComplexNumber(-4.122, 0).toString());
  }

  @Test
  void add() {
    var a = new ComplexNumber(1, .9);
    var b = new ComplexNumber(3.5, 2.1);
    assertEquals("4.5+3.0i", a.add(b).toString());
    assertThrows(ComplexNumberException.class, () -> {
      a.add(null);
    });
  }

  @Test
  void sub() {
    var a = new ComplexNumber(1, 1);
    var b = new ComplexNumber(3.5, 1);
    // 实际值确实是-2.5-1.2i
    // 但是浮点数存储为-2.5-1.2000000000000002i
    // 浮点数的判断是不准确的
    assertEquals("-2.5", a.sub(b).toString());
    assertThrows(ComplexNumberException.class, () -> {
      a.sub(null);
    });
  }

  @Test
  void mul() {
    var a = new ComplexNumber(1, 1);
    var b = new ComplexNumber(2, 20);
    assertEquals("-18.0+22.0i", a.mul(b).toString());
    assertThrows(ComplexNumberException.class, () -> {
      a.mul(null);
    });
  }

  @Test
  void div() {
    var a = new ComplexNumber(1, 1);
    var b = new ComplexNumber(2, 2);
    var c = new ComplexNumber(0, 0);
    assertEquals("0.5", a.div(b).toString());
    assertThrows(ComplexNumberException.class, () -> {
      a.div(null);
    });
    assertThrows(ComplexNumberException.class, () -> {
      b.div(c);
    });
  }

  @Test
  void testEquals() {
    var a = new ComplexNumber(1, 1);
    var b = new ComplexNumber(2, 2);
    assertNotEquals(null, a);
    assertNotEquals(a, b);
    assertEquals(a, ComplexNumber.parseComplexNumber("1+1i"));
  }
}