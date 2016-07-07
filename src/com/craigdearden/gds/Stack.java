/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.gds;

public class Stack<T> {

  /**
   * The top node on the stack.
   */
  private StackNode<T> top;

  /**
   * Adds a node with value <code>data</code> to the top of the stack.
   *
   * @param data Value contained in the stack node.
   */
  public void push(T data) {
    top = new StackNode(data, top);
  }

  /**
   * Look at the top node of the stack.
   *
   * @return the value of the node at the top of the stack.
   */
  public T peek() {
    return top.getData();
  }

  /**
   * Removes the top node from the stack returning the value of that
   * node.
   *
   * @return the value contained in the top node.
   * @throws EmptyStackException If the stack does not contain any nodes.
   */
  public T pop() throws EmptyStackException {
    if (top == null) {
      throw new EmptyStackException();
    }

    StackNode<T> removed = top;
    top = top.getNext();
    return removed.getData();
  }

  /**
   * @return true if the stack contains no nodes.
   */
  public boolean isEmpty() {
    return top == null;
  }

}
