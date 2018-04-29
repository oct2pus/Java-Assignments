/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardinventory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Austin LaBerta
 */
public class WizardInventory {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		menu();
	}
	
	// calls other functions based on player commands
	public static void menu() {
		// declarations
		ArrayList<String> inventory = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String response;
		boolean gameLoop = true;

		// stocking ArrayLists
		inventory.add("wooden staff");
		inventory.add("wizard hat");
		inventory.add("cloth shoes");
		
		// menu
		System.out.println("COMMAND MENU");
		System.out.println("show -  Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit -  Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program");
		
		// game Logic
		while (gameLoop) {

			System.out.print("Command: ");
			response = sc.nextLine();
			
			switch(response.toLowerCase()) {
				case "show":
					show(inventory);
					break;
				case "grab":
					grab(inventory);
					break;
				case "edit":
					edit(inventory);
					break;
				case "drop":
					drop(inventory);
					break;
				case "exit":
					gameLoop = false;
					System.out.println("Bye!");
					break;
				default:
					System.out.println("I don't recognize that command.");
			}
		}
	}
	
	private static void show(ArrayList<String> list) {
		for (int x = 1; x <= list.size(); x++) {
			System.out.println(x + ": " + list.get(x - 1));
		}
	}
	
	private static void grab(ArrayList<String> list1) {
		Scanner sc = new Scanner(System.in);
		String input;
		if (list1.size() < 4) {
			System.out.print("Name:");
			input = sc.nextLine();
			list1.add(input);
			System.out.println(input + " was added.");
		} else {
			System.out.println("You have 4 items. Drop something first.");
		}	
		/*Random rand = new Random();
		int item;
		if (!list2.isEmpty()) {
			if (list2.size() > 1) {
				item = rand.nextInt(list2.size());
			} else {
				item = 0;
			}
			System.out.println(list2.get(item) + " was added.");
			
			list1.add(list2.remove(item));
		} else {
			System.out.println("You can't carry any more items."
					+ " Drop something first.");
		} */
	}
	
	private static void edit(ArrayList<String> list) {
		Scanner sc = new Scanner(System.in);
		String input,
			   name;
		
		if (!list.isEmpty()) {
			System.out.print("Number: ");
			input = sc.nextLine();
			
			if(input.matches("[0-9]") && Integer.parseInt(input) <= list.size()
			&&  Integer.parseInt(input) > 0) {
				System.out.print("Updated name: ");
				name = sc.nextLine();
				list.set((Integer.parseInt(input) - 1), name);
			} else {
				System.out.println("That is not a valid number");
			}
		} else {
			System.out.println("You have no items. Grab something first.");
		}
	}
	
	private static void drop(ArrayList<String> list1) {
		Scanner sc = new Scanner(System.in);
		String input;
		if (!list1.isEmpty()) {
			System.out.print("Number: ");
			input = sc.nextLine();
			
			if(input.matches("[0-9]") && Integer.parseInt(input) <= list1.size()
			&&  Integer.parseInt(input) > 0) {
				System.out.println(list1.get(Integer.parseInt(input) -1)
								   + " was dropped.");
				list1.remove(Integer.parseInt(input) - 1);
			} else {
				System.out.println("That is not a valid number");
			}
			
		} else {
			System.out.println("You have no items. Grab something first.");
		}
	}
	
}
