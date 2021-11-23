package com.samitchell.simple_calculator;

import com.samitchell.simple_calculator.algorithms.*;
import com.samitchell.simple_calculator.data_structures.*;
import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		System.out.println("Welcome to Simple Calculator.\n"
				+ "Entry must include a single space between tokens.\n"
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
				ShuntingYard shuntingYard = new ShuntingYard(input);
				Queue<String> postfix = shuntingYard.infixToPostfix();
				
				if (postfix.isEmpty()) {
					System.out.println("Syntax error.");
				} else {
					System.out.println(postfix);
				}
			}
		}
		
		console.close();
	}

}
