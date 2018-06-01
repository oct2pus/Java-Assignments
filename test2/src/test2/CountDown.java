/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oct2pus
 */
public class CountDown implements Runnable {

	@Override
	public void run() {
		for (int x = 10; x > 0; x--)
		{
			System.out.println(this.getName() + " Count " + x);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println("Something went wrong");
			}
		}
	}

	private String getName() {
		return this.toString();
	}

	
}
