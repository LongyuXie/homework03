package com.oop.sort;

public class GUIProgram {
  private int[] data;
  private int[] result;

  private ISort sortStrategy;

  public void setData(int[] data) {
    this.data = data;
  }

  public void sort() {
    if (sortStrategy != null) {
      var copied = this.data.clone();
      this.sortStrategy.sort(copied);
      this.result = copied;
    }
  }

  public void printResult() {
    if (result != null) {
      for (int n : result) {
        System.out.printf("%d ", n);
      }
      System.out.println();
    }
  }

  public int[] getData() {
    return data;
  }

  public ISort getSortStrategy() {
    return sortStrategy;
  }

  public void setSortStrategy(ISort sortStrategy) {
    this.sortStrategy = sortStrategy;
  }
}
