/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.compiler;


public class SimpleCompilerTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    InfixToPostfixConverter ic = new InfixToPostfixConverter();
    
    String prefix =  "(6 + 2) * 5 - 8 / 4"; 
    String postfix = ic.convertToPostfix(prefix).toString();
    System.out.println(postfix);
    
    PostfixEvaluator ev = new PostfixEvaluator();
    int result = ev.evaluatePostfixExpression(postfix);
    System.out.println("Result: " + result);
  }
  
}
