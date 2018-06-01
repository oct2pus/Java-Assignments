package timer;


import java.util.Timer;
import java.time.Clock;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.TimerTask;
import java.lang.Thread;
import java.lang.Runnable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Austin LaBerta
 */
public class TimerThread extends java.lang.Thread {
	Thread thread;
	long dur;
	
	public TimerThread(long dur) {
		thread = new Thread();
		this.dur = dur;
	}
	
	@Override
	public void run() {
		System.out.println("Try to guess it in " + dur + " seconds!");
		System.out.println("Timer Started!");

		try {
			thread.sleep((dur*1000));
		} catch (InterruptedException ex) {
			Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
