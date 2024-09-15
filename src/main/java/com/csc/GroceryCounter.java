package com.csc;

public class GroceryCounter {
  private int[] counter = {0, 0, 0, 0};
  private int overflowCount = 0;

  public void hundredths() {
      if (counter[3] == 9) {
          counter[3] = 0;
          tenths();
      } else {
          counter[3]++;
      }
  }

  public void tenths() {
      if (counter[2] == 9) {
          counter[2] = 0;
          ones();
      } else {
          counter[2]++;
      }
  }

  public void ones() {
      if (counter[1] == 9) {
          counter[1] = 0;
          tens();
      } else {
          counter[1]++;
      }
  }

  public void tens() {
      if (counter[0] == 9) {
          counter[0] = 0;
          overflowCount++;
      } else {
          counter[0]++;
      }
  }

  public String total() {
      int dollarsValue = counter[0] * 10 + counter[1];
      int centsValue = counter[2] * 10 + counter[3];

      return String.format("$%d.%02d", dollarsValue, centsValue);
  }

  public int number_of_overflows() {
      return overflowCount;
  }

  public void clear() {
      for (int i = 0; i < counter.length; i++) {
          counter[i] = 0;
      }
      overflowCount = 0;
  }
}
