/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.Stack;

/**
 * No. 232 用栈实现队列
 */
public class MyQueue {
  Stack<Integer> in = new Stack();
  Stack<Integer> out = new Stack();
  /** Initialize your data structure here. */
  public MyQueue() {

  }

  public void in2out() {
    if (out.isEmpty()) {
      while (! in.isEmpty()) {
        int x = in.pop();
        out.push(x);
      }
    }
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    in.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    in2out();
    return out.pop();
  }

  /** Get the front element. */
  public int peek() {
    in2out();
    return out.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
