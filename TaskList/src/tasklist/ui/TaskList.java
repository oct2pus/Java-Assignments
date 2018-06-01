/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasklist.ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tasklist.business.Validator;
import tasklist.db.TaskDB;

/**
 *
 * @author Austin LaBerta
 */
public class TaskList {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Task List");
		menu();
		System.out.println("Bye!");
	}
	
	public static void menu() {
		// Variables
		boolean endLoop = false;
		Scanner sc = new Scanner(System.in);
		TaskDB task = new TaskDB();
		Validator valid = new Validator();
		String input;
		// Menu
		System.out.println("\nCOMMAND MENU");
		System.out.println("view\t- View pending Tasks");
		System.out.println("history\t- View completed tasks");
		System.out.println("add\t- Add a task");
		System.out.println("complete\t- Complete a task");
		System.out.println("delete\t- Delete a task");
		System.out.println("update\t- Update a task");
		System.out.println("exit\t- Exit program");
		
		do {
			System.out.print("\nCommand: ");
			input = valid.validateStr(sc);
			
			switch (input.toLowerCase()) {
				case "view":
					task.view();
					break;
				case "history":
					task.history();
					break;
				case "add":
					System.out.print("Description: ");
					input = valid.validateStr(sc);

					try {
						task.add(input);
					} catch (SQLException ex) {
						System.err.println(ex);
					}
					
					break;
				case "complete":
					System.out.print("Number: ");
					input = valid.validateInt(sc);
					try {
						task.complete(Integer.parseInt(input));
					} catch (SQLException ex) {
						System.err.println(ex);
					}
					break;
				case "delete":
					System.out.print("Number: ");
					input = valid.validateInt(sc);
					try {
						task.delete(Integer.parseInt(input));
					} catch (SQLException ex) {
						System.err.println(ex);
					}
					break;
				case "update":
					System.out.print("Number: ");
					input = valid.validateInt(sc);
					try {
						task.update(Integer.parseInt(input));
					} catch (SQLException ex) {
						System.err.println(ex);
					}
					break;
				case "exit":
					endLoop = true;
					break;
				default: 
					System.out.println("I don't understand that.");
				
			}
		} while (!endLoop);
	}
	
	
}
