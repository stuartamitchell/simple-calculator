package com.samitchell.simple_calculator.algorithms;

import com.samitchell.simple_calculator.data_structures.*;

public class ShuntingYard {
	
	private String[] tokens;
	
	public ShuntingYard(String tokenString)
	{
		this.tokens = tokenString.split(" ");
	}
	
	/**
	 * Checks if a token is a number (always a double)
	 * @param token
	 * @return	whether or not the token is a double
	 */
	private boolean isNumeric(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public Queue<String> infixToPostfix() {
		Queue<String> output = new Queue<String>();
		Stack<String> operators = new Stack<String>();
		
		for (String token : this.tokens) {
			if (this.isNumeric(token)) {
				output.enqueue(token);
			} else if (token.equals("(")) {
				operators.push(token);
			} else if (token.equals(")")) {
				while(!operators.isEmpty() && !operators.peek().equals("(")) {
					output.enqueue(operators.pop());
				}
				
				if (operators.isEmpty())
				{
					return new Queue<String>();
				} else {
					operators.pop();
				}
			} else {
				int prec1;
				
				if (token.equals("+") || token.equals("-")) {
					prec1 = 0;
				} else if (token.equals("*") || token.equals("/")) {
					prec1 = 1;
				} else {
					prec1 = 2;
				}
				
				while (!operators.isEmpty() && !operators.peek().equals("(")) {
					int prec2;
					
					if (operators.peek().equals("+") || operators.peek().equals("-")) {
						prec2 = 0;
					} else if (operators.peek().equals("*") || operators.peek().equals("/")) {
						prec2 = 1;
					} else {
						prec2 = 2;
					}
					
					if (prec2 > prec1 || (prec2 == prec1 && !token.equals("^"))) {
						output.enqueue(operators.pop());
					} else {
						break;
					}
				}
				
				operators.push(token);
			}
		}
		
		while (!operators.isEmpty()) {
			output.enqueue(operators.pop());
		}
		
		return output;
	}	
}
