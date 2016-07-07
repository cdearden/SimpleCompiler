/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.compiler;

import com.craigdearden.gds.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class InfixToPostfixConverter {
  /**
   * A collection of allowed operators.  The order they fall in this list
   * denotes the precedence that each operators have over the others. The
   * lower the index the higher the precedence.
   */
  private static final ArrayList<Character> OPERATORS = new ArrayList<>(Arrays.asList('^', '*', '/',
      '%', '+', '-'));

  /**
   * Maintains a stack of operators. Begins by pushing a '(' 
   * to the stack and a ')' to the infix. When the loop 
   * reaches the ')' in the infix the '(' will be removed 
   * from the stack, the stack will be empty and the process 
   * will be complete.
   * 
   * Loops through each character of the infix: 
   * 
   * If it is a digit it is appended to the postfix. 
   * 
   * If it is an '(' it is pushed to the stack. 
   * 
   * If it is an operator then it is compared with
   * operators on top of the stack. While the operator has 
   * lower precedence than the operator(s) at the top of the 
   * stack the operators on the stack are appended to the 
   * postfix. Then the operator read from the infix is appended
   * to the postfix. 
   * 
   * If it is a ')' then operators are popped from the stack
   * and appended to the postfix until the top of the stack
   * contains an '('.
   * 
   * @param equation the infix.
   * @return the postfix.
   */
  public StringBuffer convertToPostfix(String equation) {
    StringBuffer infix = new StringBuffer(equation);
    StringBuffer postfix = new StringBuffer();
    Stack<Character> stack = new Stack<>();

    stack.push('(');
    infix.append(')');

    int i = 0;
    while (!stack.isEmpty()) {
      char c = infix.charAt(i);
      if (Character.isDigit(c)) {
        postfix.append(c);
      } else if (c == '(') {
        stack.push(c);
      } else if (isOperator(c)) {
        while (isOperator(stack.peek()) && precedence(c, stack.peek())) {
          postfix.append(stack.pop());
        }
        stack.push(c);
      } else if (c == ')') {
        while (stack.peek() != '(') {
          postfix.append(stack.pop());
        }
        stack.pop();
      }
      i++;
    }

    return postfix;
  }

  /**
   * @param operator1
   * @param operator2
   * @return true if operator2 has precedence over operator1.
   */
  private boolean precedence(char operator1, char operator2) {
    return OPERATORS.indexOf(operator1) > OPERATORS.indexOf(operator2);
  }

  /**
   * @param c character to test.
   * @return true if <code>c</code> is an operator defined by {@link InfixToPostfixConverter#OPERATORS}.
   */
  private boolean isOperator(char c) {
    return OPERATORS.contains(c);
  }

}
