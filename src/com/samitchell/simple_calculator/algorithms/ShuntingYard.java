package com.samitchell.simple_calculator.algorithms;

import com.samitchell.simple_calculator.data_structures.*;
import java.lang.StringBuilder;

public class ShuntingYard {
	private final Operator PLUS = new Operator("+", 0, "Left");
	private final Operator MINUS = new Operator("-", 0, "Left");
	private final Operator TIMES = new Operator("*", 1, "Left");
	private final Operator DIV = new Operator("/", 1, "Left");
	private final Operator EXP = new Operator("^", 1, "Right");
	
	private String infix;
	
	public ShuntingYard(String infix)
	{
		this.infix = this.cleanUp(infix);
	}
	
	private String cleanUp(String input) {
		StringBuilder cleaned = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (Character.isDigit(cur) || cur == '+' || cur == '-' || cur == '*' ||
					cur == '/' || cur == '(' || cur == ')') {
				cleaned.append(cur + " ");
			} else {
				return "Invalid input";
			}
		}
		
		return cleaned.toString().trim();
	}
	
	public String infixToPostfix() {
		if (this.infix == "Invalid input") {
			return this.infix;
		} else {
			StringBuilder postfix = new StringBuilder(this.infix);
			
			
			return postfix.toString();
		}
	}
}
