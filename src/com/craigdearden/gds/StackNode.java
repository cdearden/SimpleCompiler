/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.gds;

public class StackNode<T> {

  /**
   * The value contained in this node
   */
  private final T data;

  /**
   * The next node in the stack.
   */
  private StackNode<T> next;

  /**
   * Adds a node with value <code>data</code> linking it with another node.
   *
   * @param data
   */
  StackNode(T data, StackNode node) {
    this.data = data;
    next = node;
  }

  /**
   * @return the value contained in this node.
   */
  public T getData() {
    return data;
  }

  /**
   * @return the next node.
   */
  public StackNode<T> getNext() {
    return next;
  }
}
