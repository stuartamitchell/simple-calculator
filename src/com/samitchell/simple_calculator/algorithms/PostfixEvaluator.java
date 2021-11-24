package com.samitchell.simple_calculator.algorithms;

import com.samitchell.simple_calculator.data_structures.*;

public class PostfixEvaluator {
	private Queue<String> postfix;
	
	/**
	 * Default constructor - sets postfix to everyone's favorite fundamental calculation
	 */
	public PostfixEvaluator() {
		this.postfix = new Queue<String>();
		postfix.enqueue("1");
		postfix.enqueue("1");
		postfix.enqueue("+");
	}
	
	/**
	 * Non-default constructor
	 * @param postfix	the queue to compute on
	 */
	public PostfixEvaluator(Queue<String> postfix) {
		this.postfix = postfix;
	}
	
	/**
	 * Applies a function to an input
	 * @param fn	the function to apply
	 * @param n		the number to apply the function to
	 * @return	the result of applying the function - defaults to the identity
	 */
	private double applyFunction(String fn, double n) {
		switch (fn) {
			case "ARCCOS":
				return Math.acos(n);
			case "ARCSIN":
				return Math.asin(n);
			case "ARCTAN":
				return Math.atan(n);
			case "COS":
				return Math.cos(n);
			case "LOG":
				return Math.log10(n);
			case "LN":
				return Math.log(n);
			case "SIN":
				return Math.sin(n);
			case "SQRT":
				return Math.sqrt(n);
			case "TAN":
				return Math.tan(n);
			default:
				return n;
		}
	}
	
	/**
	 * Evaluates the postfix expression
	 * @return	the result of evaluating the postfix expression
	 */
	public double evaluate() {
		Stack<Double> results = new Stack<Double>();
		
		while(!this.postfix.isEmpty()) {
			String token = postfix.dequeue();
			
			if (TokenTests.isNumber(token)) {
				results.push(Double.parseDouble(token));
			} else if (TokenTests.isNEG(token)) {
				double n = results.pop();
				results.push(-1 * n);
			} else if (TokenTests.isFunction(token)) {
				double fnApplied = this.applyFunction(token, results.pop());
				
				if (fnApplied == Double.NaN) {
					return Double.NaN;
				} else {
					results.push(fnApplied);
				}
			} else if (TokenTests.isOperator(token)) {
				double right = results.pop();
				double left = results.pop();
				
				switch (token) {
					case "+":
						results.push(left + right);
						break;
					case "-":
						results.push(left - right);
						break;
					case "*":
						results.push(left * right);
						break;
					case "/":
						results.push(left / right);
						break;
					case "^":
						results.push(Math.pow(left, right));
				}
			}
		}
		
		return results.pop();
	}
}
