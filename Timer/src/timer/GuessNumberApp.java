import java.util.Scanner;
import java.util.Timer;
import timer.TimerThread;


public class GuessNumberApp {
    
    public static void main(String[] args) {
		
		final int LIMIT = 10;
		TimerThread timer = new TimerThread(LIMIT);
		
        System.out.println("Guess the number!");
        System.out.println("I'm thinking of a number from 1 to " + LIMIT);
        timer.start();
		System.out.println("");
        // get a random number between 1 and the limit
        double d = Math.random() * LIMIT; // d is >= 0.0 and < limit
        int number = (int) d;             // convert double to int
        number++;                         // int is >= 1 and <= limit

        Scanner sc = new Scanner(System.in);            
        int count = 1;
        while (true) {
            System.out.print("Your guess: ");
            int guess = sc.nextInt();
            
            if (guess < 1 || guess > LIMIT) {
                System.out.println("Invalid guess. Try again.");
                continue;
            }
            
            if (guess < number) {
                System.out.println("Too low.");
            } else if (guess > number) {
                System.out.println("Too high.");
            } else {
                System.out.println("You guessed it in " + 
                                   count + " tries.\n");
				if (timer.isAlive())
				{
					System.out.println("You did it!\nThe Application will finish when the timer finishes.");
				}
				else
				{
					System.out.println("Not fast enough!");
				}
                break;
            }            
            count++;
        }
        System.out.println("Bye!");
    }
	
	
}
