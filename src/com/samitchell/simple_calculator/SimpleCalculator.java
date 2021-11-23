package com.samitchell.simple_calculator;

import com.samitchell.simple_calculator.algorithms.*;
import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		System.out.println("Welcome to Simple Calculator.\nType 'exit' to exit.");
		Scanner console = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			System.out.print("> ");
			String input = console.nextLine();
			
			if (input.equals("exit")) {
				running = false;
				System.out.println("Exiting...");
			} else {
				ShuntingYard shuntingYard = new ShuntingYard(input);
				String postfix = shuntingYard.infixToPostfix();
				
				if (postfix == "Invalid input") {
					System.out.println("Syntax error.");
				} else {
					System.out.println(postfix);
				}
			}
		}
		
		console.close();
	}

}
