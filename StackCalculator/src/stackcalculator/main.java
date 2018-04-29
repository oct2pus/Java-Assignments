/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcalculator;

import java.util.Scanner;

/**
 *
 * @author Austin LaBerta
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	
	// displays startup message and starts shell()
	public static void main(String[] args) {
		System.out.println("Welcome to the Stack Calculator.");
		System.out.println("Commands: push n, add, sub, mult, div, clear,"
						   +"or quit");
		shell();
	}
	
	// called shell because it reminds me of command line interpretters
	// or terminal shells, manages the calculator loop
	public static void shell() {
		StackCalculator calc = new StackCalculator();
		Scanner sc = new Scanner(System.in);
		String input;
		double[] values;
		double dubInput;
		Boolean loop = true;
		
		while (loop){
			System.out.print("stack> ");
			input = sc.next();
			switch(input) {
				case "push":
					input = sc.next();
					if (input.matches("[0-9]*|[0-9]*\\.(?=[0-9])[0-9]*")) {
						dubInput = Double.parseDouble(input);
					} else {
						error(sc);
						break;
					}
					calc.push(dubInput);
					break;
				case "add":
					if (calc.size() < 2) {
						error(sc);
						break;
					} else {
						calc.add();
					}
					break;
				case "sub":
					if (calc.size() < 2) {
						error(sc);
						break;
					} else {
						calc.subtract();
					}
					break;
				case "mult":
					if (calc.size() < 2) {
						error(sc);
						break;
					} else {
						calc.multiply();
					}
					break;
				case "div":
					if (calc.size() < 2) {
						error(sc);
						break;
					} else {
						calc.divide();
					}
					break;
				case "clear":
					calc.clear();
					break;
				case "quit":
					loop = false;
					System.out.println("Thanks for using the Stack Calculator.");
					break;
				default:
					error(sc);
			}
			values = calc.getValues();
			if (calc.size() > 0) {
			
				for (int x = 0; x < calc.size(); x++) {
				System.out.println(values[x]);
				}
			} else {
				System.out.println("empty");
			}
		}
	}	
	private static void error(Scanner sc) {
		System.out.println("invalid command");
		sc.reset();
	}
}

