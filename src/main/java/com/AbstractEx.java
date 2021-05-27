package com;

public interface AbstractEx {
  default void input(){}
  default void output(){}
  default void solve(){}
  default void run(){
    input();
    solve();
    output();
  }
}
