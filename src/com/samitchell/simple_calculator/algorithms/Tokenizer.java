package com.samitchell.simple_calculator.algorithms;

public class Tokenizer {
	private String input;
	
	public Tokenizer() {
		this("1+1");
	}
	
	public Tokenizer(String input) {
		this.input = input;
	}
	
	public String toTokenString() {
		StringBuilder tokenString = new StringBuilder();
		
		for(int i = 0; i < this.input.length(); i++) {
			char cur = this.input.charAt(i);
			
			if (Character.isDigit(cur)) {
				StringBuilder token = new StringBuilder();
				token.append(cur);
				
				while ( (i + 1 < this.input.length()) && ( input.charAt(i + 1) == '.' || Character.isDigit(this.input.charAt(i + 1)) ) ) {
					i++;
					token.append(this.input.charAt(i));
				}
				
				tokenString.append(token.toString() + " ");
			} else if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || cur == '^' || cur == '(' || cur == ')') {
				tokenString.append(cur + " ");
			} else if (cur != ' '){
				return "Invalid input";
			}
		}
		
		return tokenString.toString();
	}
}
