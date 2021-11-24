package com.samitchell.simple_calculator.algorithms;

public class TokenTests {
	/**
	 * Checks whether the token is a function
	 * @param token		the token to test
	 * @return	whether or not the token is a function
	 */
	public static boolean isFunction(String token) {
		if (token.equals("ARCCOS") || token.equals("ARCSIN") || token.equals("ARCTAN") 
				|| token.equals("COS") || token.equals("LOG") || token.equals("LN")
				|| token.equals("SIN") || token.equals("SQRT") || token.equals("TAN")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks whether a token is a left parenthesis
	 * @param token		the token to test
	 * @return	whether or not the token is a left parenthesis
	 */
	public static boolean isLParen(String token) {
		return token.equals("(");
	}
	
	public static boolean isNEG(String token) {
		return token.equals("NEG");
	}
	
	/**
	 * Checks whether a token is a right parenthesis
	 * @param token	the token to test
	 * @return	whether or not the token is a right parenthesis
	 */
	public static boolean isRParen(String token) {
		return token.equals(")");
	}
	
	/**
	 * Checks if a token is a number (always a double)
	 * @param token
	 * @return	whether or not the token is a double
	 */
	public static boolean isNumber(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if a token is an operator
	 * @param token
	 * @return
	 */
	public static boolean isOperator(String token) {
		if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")
				|| token.equals("^")) {
			return true;
		} else {
			return false;
		}
	}
}
