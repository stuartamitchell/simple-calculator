package com.samitchell.simple_calculator;

import com.samitchell.simple_calculator.algorithms.*;
import com.samitchell.simple_calculator.data_structures.*;
import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		System.out.println("Welcome to Simple Calculator.\n"
				+ "Type 'exit' to exit.");
		Scanner console = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			System.out.print("> ");
			String input = console.nextLine();
			
			if (input.equals("exit")) {
				running = false;
				System.out.println("Done.");
			} else {
				Tokenizer tokenizer = new Tokenizer(input);
				String[] tokens = tokenizer.toTokenString();
				
				if (tokens == null) {
					System.out.println("Syntax error.");
				} else {
					ShuntingYard shuntingYard = new ShuntingYard(tokens);
					Queue<String> postfix = shuntingYard.infixToPostfix();
					
					if (postfix.isEmpty()) {
						System.out.println("Mismatched parentheses.");
					} else {
						PostfixEvaluator postfixEvaluator = new PostfixEvaluator(postfix);
						double result = postfixEvaluator.evaluate();
						
						if (result == Double.NaN) {
							System.out.println("Math error.");
						} else {
							System.out.println(result);
						}
					}
				}
			}
		}
		
		console.close();
	}

}
