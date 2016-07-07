
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.compiler;

import com.craigdearden.gds.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class PostfixEvaluator {
  /**
   * A list of acceptable operators.
   */
  private static final ArrayList<Character> OPERATORS = new ArrayList<>(Arrays.asList('^', '*', '/',
      '%', '+', '-'));
  
  /**
   * Evaluates the postfix.
   * 
   * Appends a ')' to the postfix to mark the end of the postfix.
   * 
   * Loops through the characters in the postfix.
   * 
   * If the character is a digit (an operand) it is pushed to the
   * stack.
   * 
   * If the character is an operator then the two operands are 
   * taken from the stack and the calculation is performed. 
   * The result is pushed to the stack and becomes one of the
   * next operands.
   * 
   * 
   * @param postfix 
   * @return the calculated result.
   */
  public int evaluatePostfixExpression(String postfixInput) {
    StringBuffer postfix = new StringBuffer(postfixInput);
    Stack<Integer> stack = new Stack();
    postfix.append(')');
    
    int operand2 = 0;
    int operand1 = 0;
    int result = 0;
    int i = 0;
    char c = postfix.charAt(i);
    while(c != ')') {
      if(Character.isDigit(c)) {
        stack.push(Integer.parseInt(Character.toString(c)));
      } else if (OPERATORS.contains(c)) {
        operand2 = stack.pop();
        operand1 = stack.pop();
        result = calculate(operand1,operand2,c);
        stack.push(result);
      }
      i++;
      c = postfix.charAt(i);
    }
    
    result = stack.pop();
    return result;
  }

  /**
   * Translates the character operators into actual mathematical equations.
   * 
   * @param operand1 the first operand in the postfix.
   * @param operand2 the second operand in the postfix.
   * @param operator defines the operation that will be performed.
   * @return the calculated result of the operation.
   */
  private int calculate(int operand1, int operand2, char operator) {
    int result = 0;
    switch (operator) {
      case '^':
        result = (int) Math.pow(operand1, operand2);
        break;
      case '*':
        result = operand1 * operand2;
        break;
      case '/':
        result = operand1 / operand2;
        break;
      case '%':
        result = operand1 % operand2;
        break;
      case '+':
        result = operand1 + operand2;
        break;
      case '-':
        result = operand1 - operand2;
        break;
      default:
    }
    return result;
  }

}
