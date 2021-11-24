package com.samitchell.simple_calculator.algorithms;

import com.samitchell.simple_calculator.data_structures.*;

/**
 * A class for the shunting yard algorithm for parsing a mathematical expression in infix
 * notation to postfix or reverse Polish notation
 * 
 * @author Stuart A Mitchell
 *
 */
public class ShuntingYard {
	
	private String[] tokens;
	
	/**
	 * Default constructor - passes our favorite fundamental calculation to tokens
	 */
	public ShuntingYard() {
		this(new String[] { "1", "+", "1" });
	}
	
	/**
	 * Non-default constructor
	 * @param tokens	an array of string tokens
	 */
	public ShuntingYard(String[] tokens)
	{
		this.tokens = tokens;
	}
	
	/**
	 * Converts an array of string tokens to a queue in reverse Polish notation
	 * @return	a queue in reverse Polish notation
	 */
	public Queue<String> infixToPostfix() {
		Queue<String> output = new Queue<String>();
		Stack<String> operators = new Stack<String>();
		
		if (this.isBalanced()) {
			for (String token : this.tokens) {
				if (TokenTests.isNumber(token)) {
					output.enqueue(token);
				} else if (TokenTests.isNEG(token)) {
					operators.push(token);
				} else if (TokenTests.isFunction(token)) {
					operators.push(token);
				} else {
					int prec1 = this.precedence(token);
					
					if (prec1 == 0) {
						operators.push(token);
					} else if (prec1 == 4) {
						while(!TokenTests.isLParen(operators.peek())) {
							output.enqueue(operators.pop());
						}
						
						operators.pop();
					} else {
						while(!operators.isEmpty()) {
							int prec2 = this.precedence(operators.peek());
							
							if (prec2 > prec1 || (prec2 == prec1 && !token.equals("^"))) {
								output.enqueue(operators.pop());
							} else {
								break;
							}
						}
						
						operators.push(token);
					}
				}
			}
			
			while (!operators.isEmpty()) {
				output.enqueue(operators.pop());
			}
			
			return output;
		} else {
			return new Queue<String>();
		}
	}
	
	/**
	 * Checks if the parentheses in tokens are balanced
	 * @return	whether or not the parentheses in tokens are balanced
	 */
	private boolean isBalanced() {
		Stack<String> parens = new Stack<String>();
		for (String token : this.tokens) {
			if (TokenTests.isLParen(token)) {
				parens.push(token);
			} else if (TokenTests.isRParen(token)) {
				if(parens.isEmpty()) {
					return false;
				} else {
					parens.pop();
				}
			}
		}
		
		if (parens.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gets the precedence of operator
	 * @param operator	the operator for which to find the precedence
	 * @return	the operator's precedence
	 */
	private int precedence(String operator) {
		if (TokenTests.isLParen(operator)) {
			return 0;
		} else if (operator.equals("+") || operator.equals("-")) {
			return 1;
		} else if (operator.equals("*") || operator.equals("/")) {
			return 2;
		} else if (operator.equals("^")) {
			return 3;
		} else {
			return 4;
		}
		
	}
}
