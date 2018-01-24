/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loancalculator;

import java.util.Scanner;
import java.text.NumberFormat;


/**
 *
 * @author oct2pus
 */
public class LoanCalculator {

    /**
     * Welcome to the Loan Calculator

DATA ENTRY
Enter loan amount:          ten
Error! Invalid decimal value. Try again.
Enter loan amount:          -1
Error! Number must be greater than 0.0
Enter loan amount:          100000000000
Error! Number must be less than 1000000.0
Enter loan amount:          500000
Enter yearly interest rate: 5.6
Enter number of years:      thirty
Error! Invalid integer value. Try again.
Enter number of years:      -1
Error! Number must be greater than 0
Enter number of years:      100
Error! Number must be less than 100
Enter number of years:      30

FORMATTED RESULTS
Loan amount:          $500,000.00
Yearly interest rate: 5.6%
Number of years:      30
Monthly payment:      $2,870.39

Continue? (y/n):
Error! This entry is required. Try again.
Continue? (y/n): x
Error! Entry must be 'y' or 'n'. Try again.
Continue? (y/n): n
     */
    public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getInstance();
		double  loanAmount,
				yearlyInterestRate,
				monthlyInterestRate,
				monthlyPayment;
		int		years,
				months;
		
		nf.setMaximumFractionDigits(2);

		
		System.out.println("Welcome to Loan Calculator");
		System.out.print("DATA ENTRY\n");
        loanAmount = getDoubleWithinRange(sc,
				"Enter Loan Amount:\t\t", 0.0, 1000000.0);
		yearlyInterestRate = getDoubleWithinRange(sc,
				"Enter yearly interest rate:\t", 0.0, 20.0);
		years = getIntWithinRange(sc, "Enter number of years:\t\t", 0, 100);
		
		months = years * 12;
		monthlyInterestRate = (yearlyInterestRate/100) / 12;
		monthlyPayment = loanAmount * monthlyInterestRate /
				(1 - 1/Math.pow(1 + monthlyInterestRate, months));
		
		System.out.println("\nFORMATTED RESULTS");
		System.out.println("Loan amount:\t\t$"+nf.format(loanAmount));
		System.out.println("Yearly interest rate:\t"+
						   nf.format(yearlyInterestRate)+"%");
		System.out.println("Number of years:\t"+years);
		System.out.println("Monthly payment:\t$"+nf.format(monthlyPayment));
    }
    
    public static double getDoubleWithinRange(Scanner sc, String prompt,
    double min, double max)
    {
		double result = 0.0;
		boolean end = false;
		do
		{
			try
			{
				System.out.print(prompt);
				result = sc.nextDouble();
				
				if (result < min)
				{
					System.out.println("Error! Number must be greater than "+min);
				}
				else if (result > max)
				{
					System.out.println("Error! Number must be less than "+max);
				}
				else
				{
					end = true;
				}
			}
			catch (java.util.InputMismatchException Ex)
			{
				System.out.println("Error! Invalid decimal value. Try again.");
				sc.nextLine();
			}
		}
		while (!end);
		return result;
    }        
    
    public static int getIntWithinRange(Scanner sc, String prompt,
    int min, int max)
    {
		int result = 0;
		boolean end = false;
		do
		{
			try
			{
				System.out.print(prompt);
				result = sc.nextInt();
				if (result < min)
				{
					System.out.println("Error! Number must be greater than "+min);
				}
				else if (result > max)
				{
					System.out.println("Error! Number must be less than "+max);
				}
				else
				{
					end = true;
				}
			}
			catch (java.util.InputMismatchException Ex)
			{
				System.out.println("Error! Invalid integer value. Try again.");
				sc.nextLine();
			}
		}
		while (!end);
		return result;
    }
}
