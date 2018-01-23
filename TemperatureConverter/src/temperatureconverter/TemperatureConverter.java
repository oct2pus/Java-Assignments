package temperatureconverter;

import java.util.Scanner;
import java.text.NumberFormat;
/**
 *
 * @author Austin LaBerta
 */
public class TemperatureConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getInstance();
        float degrees;
        String input;
        boolean cont;
        
        nf.setMaximumFractionDigits(2);
                
        System.out.println("Welcome to Temperature Converter.");

        do
        {
            System.out.print("\nEnter degrees in Fahrenheit: ");
            degrees = sc.nextFloat();
            
            degrees = (degrees-32) * 5/9;
            
            System.out.print("\nDegrees in Celsius: "+nf.format(degrees));
            
            System.out.print("\nContinue? (y/n) ");
            input = sc.next();
            
            cont = input.toLowerCase().equals("y");
                    
        } while (cont == true);
    }

}

/** 
 *run:
 *Welcome to Temperature Converter.
 *
 *Enter degrees in Fahrenheit: 212
 *
 *Degrees in Celsius: 100
 **Continue? (y/n) y
 *
 *Enter degrees in Fahrenheit: 32
 *
 *Degrees in Celsius: 0
 *Continue? (y/n) y
 *
 *Enter degrees in Fahrenheit: 77.5
 *
 *Degrees in Celsius: 25.28
 *Continue? (y/n) n
 *BUILD SUCCESSFUL (total time: 57 seconds)
 */