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
public class PersonApp {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = null;
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Welcome to the Person Tester application");
			Person person = null;

			person = fillOutForm(sc);

			print(person);
			
			System.out.print("Continue? (y/n) ");
			input = sc.next();
			if (input.toLowerCase().equals("n"))
			{
				quit = true;
			}
		}
		
		sc.close();
		
	}
	
	public static Person fillOutForm(Scanner sc)
	{
		Validator valid = new Validator();
		Person person = null;
				
		person = valid.validateChoice(sc, "Create Customer or Employee?"
											 + " (c/e): ");
		
		System.out.print("\n");
		
		person.setFirstName(valid.validateName(sc, "Enter First Name: "));
		
		person.setLastName(valid.validateName(sc, "Enter Last Name: "));
		
		person.setEmail(valid.validateEmail(sc, "Enter Email Address: "));
		
		if (person instanceof Customer)
		{
			((Customer) person).setCustomerNumber(valid.validateCustomerNumber(
								sc, "Enter Customer Number: "));
		}
		else if (person instanceof Employee)
		{
			((Employee) person).setPhoneNumber(valid.validatePhoneNumber(sc, 
								 "Enter Phone Number: "));
		}
		
		return person;
	}
	
	public static void print(Person person)
	{
		System.out.println("\nYou Entered:" + person.getDisplayText());
	}
}
