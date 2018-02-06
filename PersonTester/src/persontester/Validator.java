/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontester;

import java.util.Scanner;

/**
 *
 * @author Austin LaBerta
 */
public class Validator
{
	private String errorMessage;
	
	public Validator()
	{
		errorMessage = "Invalid input!!\nTry again.";
	}
		
	public Person validateChoice(Scanner sc, String prompt)
	{
		String input = null;
		boolean leave = false;
		Person output = null;
		
		while(!leave)
		{
			System.out.print(prompt);
			input = sc.next();
			
			if (!input.matches("[ce]"))
			{
				System.out.println("Invalid input!!\nTry again.");
			}
			else
			{
				if (input.equals("c"))
				{
					output = new Customer();
				}
				else if (input.equals("e"))
				{
					output = new Employee();
				}
					
				leave = true;
			}
		}
		
		return output;
	}
	// uncertain how you wanted Customer Numbers formated, assuming a length of
	// 6, with the 1st space a character and the following 5 spaces are digits
	public String validateCustomerNumber(Scanner sc, String prompt)
	{
		String custNumb = null;
		boolean leave = false;
		
		while(!leave)
		{
			System.out.print(prompt);
			custNumb = sc.next();
			
			if (custNumb.matches("[a-zA-Z][0-9]{5}"))
			{
				leave = true;
			}
			else
			{
				System.out.print(errorMessage);
			}
		}
		
		return custNumb;
	}
	
	public String validateEmail(Scanner sc, String prompt)
	{
		String email = null;
		boolean leave = false;
		
		while (!leave)
		{
			System.out.print(prompt);
			email = sc.next();
			
			if (email.matches("[a-zA-Z0-9]++@[a-zA-Z0-9]++.[a-zA-Z.]++"))
			{
				leave = true;
			}
			else
			{
				System.out.print(errorMessage);
			}
		}
		
		return email;
	}
	
	public String validateName(Scanner sc, String prompt)
	{
		String name = null;
		boolean leave = false;
		
		while (!leave)
		{
			System.out.print(prompt);
			name = sc.next();
			
			if (name.matches("[a-zA-Z]++"))
			{
				leave = true;
			}
			else
			{
				System.out.println(errorMessage);
			}
		}
		
		return name;
	}
	
	public String validatePhoneNumber(Scanner sc, String prompt)
	{
		String phoneNumber = null;
		boolean leave = false;
		
		while(!leave)
		{
			System.out.print(prompt);
			phoneNumber = sc.next();
			
			if (phoneNumber.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}"))
			{
				leave = true;
			}
			else
			{
				System.out.print(errorMessage);
			}
		}
		
		return phoneNumber;
	}
	
}
