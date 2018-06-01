/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tortoiseandharerace;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Austin LaBerta
 */
public class RunnerThread extends Thread {
	private String name;
	private int restChance,
				speed,
				progress;
	
	public RunnerThread(String name, int speed, int restChance) {
		// Locking rest chance within 100
		if (restChance > 100) {
			restChance = 100;
		} else if (restChance < 0) {
			restChance = 0;
		}
		// assign variables based on parameters
		this.name = name;
		this.speed = speed;
		this.restChance = restChance;
		// assign progress to 0
		progress = 0;
	}

	@Override
	public void run() {
		Random rand = new Random();
		int min = 1,
			max = 100;
		while (progress < 1000) {
			if ((min + rand.nextInt(max) > restChance)) {
				progress+= speed;
				System.out.println(name + ": " + progress);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				System.err.println(ex);
			}
		}
		System.out.println(name + ": I finished!");
	}
}
