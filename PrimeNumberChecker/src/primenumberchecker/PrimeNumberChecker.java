package primenumberchecker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Austin LaBerta
 */
public class PrimeNumberChecker {

	public static void main(String[] args) {
		
		// constants
		final int MAX = 5000;
		final int MIN = 1;
		
		// primatives
		int primeInput;
		boolean programLoop = true,
				result;
		
		// objects
		String loopInput;
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		
		// Program Logic
		System.out.println("Prime Number Checker");
		
		while (programLoop) {
			
			primeInput = checkLoop(sc, MAX, MIN);
			
			result = primeCheck(primeInput, list);
			
			if (result) {
				System.out.println(primeInput + " is NOT a prime number.");
				System.out.print("It has " + list.size() + " factors: ");
				
				for (Integer x: list) {
					System.out.print(x + " ");
				}
				
				System.out.print("\n");
			} else {
				System.out.println(primeInput + " is a prime number.");
			}
			
			System.out.print("Try again? (y/n): ");
			sc.reset();
			loopInput = sc.next();
			
			if (loopInput.toLowerCase().equals("n")) { 
				programLoop = false;
			} else {
				list.clear();
			}
		}
		
		System.out.println("Bye!");
	}
	
	// validates input
	public static int checkLoop(Scanner sc, int max, int min) {
		int input = min;
		boolean valid = false;

		while (!valid) {
					
		System.out.print("\nPlease enter an integer between " + min + " and "
							+ max + ": ");
			input = sc.nextInt();

			if (input >= min && input <= max) {
				
				valid = true;
				
			} else {
				System.out.println("\nInvalid input");
			}
		}
		
		return input;
	}
	
	// checks if number is prime and counts factors
	// done in same function to keep program at O(n) instead of O(2n)
	public static boolean primeCheck(int input, ArrayList list) {
		boolean output = false;
		
		// all numbers divisible by 1
		list.add(1);
		
		for (int x = 2; x < input; x++) { 
		// assumed start at 2 to deal with factors below minimum
		
		if (input % x == 0) {
				list.add(x);
				output = true;	
			}
		}
		
		// all numbers divisble by self
		list.add(input);
		
		return output;
	}
	
}
