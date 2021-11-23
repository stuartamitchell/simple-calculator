package com.samitchell.simple_calculator.algorithms;

import com.samitchell.simple_calculator.data_structures.*;
import java.lang.StringBuilder;

public class ShuntingYard {
	
	private String[] tokens;
	
	public ShuntingYard(String infix)
	{
		this.tokens = infix.split(" ");
	}
	
	/**
	 * Checks if a token is a number (always a double)
	 * @param token
	 * @return	whether or not the token is a double
	 */
	private boolean tokenIsNumeric(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public Queue<String> infixToPostfix() {
		Queue<String> output = new Queue<String>();
		
		for (String token : this.tokens) {
			
		}
		
		return output;
	}	
}
