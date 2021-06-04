package com.oop.sort;

public class SelectSort implements ISort {
  @Override
  public void sort(int[] data) {
    var len = data.length;
    for (int i = 0; i < len; i++) {
      int mi = i;
      for (int j = i + 1; j < len; j++) {
        if (data[j] < data[mi]) {
          mi = j;
        }
      }
      int temp = data[i];
      data[i] = data[mi];
      data[mi] = temp;
    }
  }

  public static void main(String[] args) {
    int[] data = {4, 1, 0, 9, 10, 8, 7, 1, 2};
    ISort s = new SelectSort();
    s.sort(data);
    for (int datum : data) {
      System.out.printf("%d ", datum);
    }
    System.out.println();
  }
}
