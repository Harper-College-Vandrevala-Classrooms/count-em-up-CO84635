package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
  }

  @Test
  void testInitialValue() {
    assertEquals("$0.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void testHundreths() {
    counter.hundredths();
    assertEquals("$0.01", counter.total());
  }

  @Test
  void testTenths() {
    counter.clear();
    counter.tenths();
    assertEquals("$0.10", counter.total());
  }

  @Test
  void testOnes() {
    counter.clear();
    counter.ones();
    assertEquals("$1.00", counter.total());
  }

  @Test
  void testTens() {
    counter.clear();
    counter.tens();
    assertEquals("$10.00", counter.total());
  }

  @Test
  void testHundredthsToTenths() {
    counter.clear();
    for (int i = 0; i < 10; i++) {
      counter.hundredths();
    }
    assertEquals("$0.10", counter.total());
  }

  @Test
  void testTenthsToOnes() {
    counter.clear();
    for (int i = 0; i < 10; i++) {
      counter.tenths();
    }
    assertEquals("$1.00", counter.total());
  }


  @Test
  void testClear() {
    for (int i = 0; i < 100; i++) {
      counter.tens();
    }
    counter.clear();
    assertEquals("$0.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void testExampleOutputOverflow() {
    counter.tens();
    counter.tens();
    counter.hundredths();
    for (int i = 0; i < 35; i++) {
      counter.ones();
    }
    for (int i = 0; i < 100; i++) {
      counter.ones();
    }
    assertEquals("$55.01", counter.total());
    assertEquals(1, counter.number_of_overflows());
  }

  @Test
  void testOverflowOnes() {
    for (int i = 0; i < 100; i++) {
      counter.ones();
    }
    assertEquals("$0.00", counter.total());
    assertEquals(1, counter.number_of_overflows());
  }

  @Test
  void testOverflowOnesToTen() {
    for (int i = 0; i < 1000; i++) {
      counter.ones();
    }
    assertEquals("$0.00", counter.total());
    assertEquals(10, counter.number_of_overflows());
  }
}

