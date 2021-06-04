package com.oop.sort;

public class InsertSort implements ISort {
  @Override
  public void sort(int[] data) {
    for (int i = 1; i < data.length; i++) {
      int n = data[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (data[j] > n) {
          data[j + 1] = data[j];
        } else {
          break;
        }
      }
      data[j + 1] = n;
    }
  }

  public static void main(String[] args) {
    int[] data = {4, 1, 0, 9, 10, 8, 7, 1, 2};
    ISort s = new InsertSort();
    s.sort(data);
    for (int datum : data) {
      System.out.printf("%d ", datum);
    }
    System.out.println();
  }
}
