package com.oop.sort;

public class BubbleSort implements ISort {
  @Override
  public void sort(int[] data) {
    int len = data.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = 0; j < len - 1 - i; j++) {
        if (data[j] > data[j + 1]) {
          int temp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] data = {4, 1, 0, 9, 10, 8, 7, 1, 2};
    ISort s = new BubbleSort();
    s.sort(data);
    for (int datum : data) {
      System.out.printf("%d ", datum);
    }
    System.out.println();
  }
}
