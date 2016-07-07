/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.gds;

public class EmptyStackException extends RuntimeException {
  public EmptyStackException() {
    super("Stack is empty.");
  }
}
