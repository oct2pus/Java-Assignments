/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesreport;

import java.text.NumberFormat;
/**
 *
 * @author Austin LaBerta
 */
public class SalesReport {

	public static void main(String[] args) {
		double[][] sales = {
			{1540.0, 2010.0, 2450.0, 1845.0}, // Region 1
			{1130.0, 1168.0, 1847.0, 1491.0}, // Region 2
			{1580.0, 2305.0, 2710.0, 1284.0}, // Region 3
			{1105.0, 4102.0, 2391.0, 1576.0}  // Region 4
		};
		double regionAvg = 0,
			   quarterAvg = 0,
			   total = 0;
		
		NumberFormat nf = NumberFormat.getInstance();
		
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
		
		//Section 1
		System.out.println("Region\tQ1\t\tQ2\t\tQ3\t\tQ4");
		for (int x = 0; x < sales.length; x++)
		{
			System.out.print((x+1) + "\t");
			for (int y = 0; y < sales.length; y++)
			{
				System.out.print("$" + nf.format(sales[x][y]) + "\t");
			}
			System.out.print("\n");
		}
		
		//Section 2
		System.out.println("\nSales By Region:");
		
		for (int x = 0; x < sales.length; x++)
		{
			System.out.print("Region " + (x+1) + ": ");
			for (int y = 0; y < sales.length; y++)
			{
				regionAvg += sales[x][y];
			}
			System.out.print("$" + nf.format(regionAvg) + "\n");
			regionAvg = 0;
		}
		
		//Section 3
		System.out.println("\nSales By Quarter:");
		
		for (int x = 0; x < sales.length; x++)
		{
			System.out.print("Quarter: " + (x+1) + ": ");
			for (int y = 0; y < sales.length; y++)
			{
				quarterAvg += sales[y][x];
			}
			System.out.print("$" + nf.format(quarterAvg) + "\n");
			quarterAvg = 0;
		}

		//Section 4
		System.out.print("\nTotal Sales: ");
		for (int x = 0; x < sales.length; x++)
		{
			for (int y = 0; y < sales.length; y++)
			{
				total += sales[y][x];
			}
		}
		System.out.print("$" + nf.format(total) + "\n");
}	
	
}
