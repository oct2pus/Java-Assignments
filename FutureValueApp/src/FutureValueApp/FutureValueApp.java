//This assignment was a modification on a prebuilt program
package FutureValueApp;

import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Scanner sc = new Scanner(System.in);
        String choice = "y";
		
		nf.setMaximumFractionDigits(2);
		
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = sc.nextDouble();
            //System.out.print("Enter yearly interest rate: ");
            //double interestRate = sc.nextDouble();
            System.out.print("Enter number of years:      ");
            int years = sc.nextInt();
			double[] interestRate = {5.0, 5.5, 6.0, 6.5};
			
			System.out.println("Year\t5.0%\t\t5.5%\t\t6.0%\t\t6.5%");
			for (int x = 1; x <= years; x++)
			{
				System.out.print(x+"\t");
			    for(int y = 0; y < 4; y++)
				{
					double monthlyInterestRate = interestRate[y] / 12 / 100;
					double futureValue = 0.0;
					int months = x * 12;

					for (int i = 1; i <= months; i++) {
						futureValue = (futureValue + monthlyInvestment) * 
									  (1 + monthlyInterestRate);
					}
					System.out.print(nf.format(futureValue)+"\t");
				}
				System.out.println();
			}

            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
        System.out.println("Bye!");
    }
}