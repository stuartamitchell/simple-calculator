package com.samitchell.simple_calculator.algorithms;

import java.lang.Math;

/**
 * A class for handling tokenizing a mathematical expression for parsing with
 * the shunting yard algorithm.
 * 
 * @author Stuart A Mitchell
 *
 */
public class Tokenizer {
	private String input;
	
	/**
	 * Default constructor - input is everyone's favorite fundamental calculation
	 */
	public Tokenizer() {
		this("1+1");
	}
	
	/**
	 * Non-default constructor
	 * @param input		the input string to tokenize
	 */
	public Tokenizer(String input) {
		this.input = input;
	}
	
	/**
	 * Tests whether a - token indicates a negative number or subtraction
	 * @param index	the index of the - token in the input string
	 * @return	whether or not the token indicates a negative number or subtraction
	 */
	private boolean isNegative(int index) {
		if (index == 0) {
			return true;
		} else {
			index--;
			
			while(this.input.charAt(index) == ' ' && index > 0) {
				index--;
			}
			
			if (!Character.isDigit(input.charAt(index)) || index == 0) {
				return true;
			} else {
				return false;
			}
		}	
	}
	
	/**
	 * Creates an array of string tokens
	 * @return 	an array of string tokens
	 */
	public String[] toTokenString() {
		StringBuilder tokenString = new StringBuilder();
		
		for(int i = 0; i < this.input.length(); i++) {
			char cur = this.input.charAt(i);
			
			if (Character.isDigit(cur)) {
				StringBuilder token = new StringBuilder();
				token.append(cur);
				
				while ( (i + 1 < this.input.length()) 
						&& ( input.charAt(i + 1) == '.' 
							|| Character.isDigit(this.input.charAt(i + 1)) ) ) {
					i++;
					token.append(this.input.charAt(i));
				}
				
				if (token.toString().charAt(token.toString().length() - 1) == '.') {
					return null;
				} else {
					tokenString.append(token.toString() + " ");
				}
			} else if (Character.isLetter(cur)) {
				if ((i < this.input.length() - 1) && Character.toUpperCase(cur) == 'P') {
					if (Character.toUpperCase(this.input.charAt(i + 1))== 'I') {
						tokenString.append(Double.toString(Math.PI) + " ");
						i++;
					} else {
						return null;
					}
				} else if (Character.toUpperCase(cur) == 'E') {
					tokenString.append(Double.toString(Math.E) + " ");
				} else {
					StringBuilder token = new StringBuilder();
					
					while((i < this.input.length() - 1) && cur != '(') {
						token.append(cur);
						i++;
						cur = input.charAt(i);
					}
				
					String fn = token.toString().toUpperCase();
					
					if (TokenTests.isFunction(fn)) {
						tokenString.append(fn + " ");
						i--;
					} else {
						return null;
					}
				}
			} else if (cur == '-') {
				if (this.isNegative(i)) {
					tokenString.append("NEG ");
				} else {
					tokenString.append("- ");
				}
			} else if (cur == '+' || cur == '*' || cur == '/' 
					|| cur == '^' || cur == '(' || cur == ')') {
				tokenString.append(cur + " ");
			} else if (cur != ' '){
				return null;
			}
		}
		
		String[] tokens = tokenString.toString().split(" ");
		String lastToken = tokens[tokens.length - 1];
		
		if (TokenTests.isNumber(lastToken) || TokenTests.isRParen(lastToken)) {
			return tokens;
		} else {
			return null;
		}
	}
}
