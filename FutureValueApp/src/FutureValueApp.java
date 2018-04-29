import java.util.*;
import java.text.*;

public class FutureValueApp {

    public static void main(String[] args) {
        
		LinkedList<String> list = new LinkedList<>();
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        // perform 1 or more calculations
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = Console.getDouble(
                "Enter monthly investment: ", 0, 1000);
            double interestRate = Console.getDouble(
                "Enter yearly interest rate: ", 0, 30);
            int years = Console.getInt(
                "Enter number of years: ", 0, 100);

            // calculate the future value
            double monthlyInterestRate = interestRate/12/100;
            int months = years * 12;
            double futureValue = calculateFutureValue(
                monthlyInvestment, monthlyInterestRate, months);

            // get the currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            // format the result as a single string
				String results =
                      currency.format(monthlyInvestment) + "\t"
                      + percent.format(interestRate/100) + "\t"
                      +  years + "\t"
                      + currency.format(futureValue);
			
			list.addFirst(results);
            
            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            System.out.println();
        }
		    
		if (!list.isEmpty()) {
			System.out.println();
			System.out.println("Future Value Calculations\n");
			System.out.println("Inv/Mo.\tRate\tYears\tFuture Value");
			for(String results: list) {
				System.out.println(results);
			}
		}
    }

    public static double calculateFutureValue(double monthlyInvestment,
            double monthlyInterestRate, int months) {
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue =
                (futureValue + monthlyInvestment) *
                (1 + monthlyInterestRate);
        }
        return futureValue;
    }
    
}
