/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasklist.business;

import java.util.Scanner;

/**
 *
 * @author Austin LaBerta
 */
public class Validator {
	public String validateInt(Scanner sc)
	{
		String result;
		boolean endLoop = false;
		do {
			result = sc.nextLine();
			if (result.matches("[0-9]*"))
					endLoop = true;
			else
				System.out.println("Invalid input, try again.");
		} while (!endLoop);
		
		return result;
	}
	public String validateStr(Scanner sc)
	{
		String result;
		boolean endLoop = false;
		do {
			result = sc.nextLine();
			if (!result.isEmpty())
					endLoop = true;
			else
				System.out.println("Invalid input, try again.");
		} while (!endLoop);
		
		return result;
	}
	
	
}
