/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author oct2pus
 */
public class counter extends Thread {
	private SequenceNumber s;
	public counter(SequenceNumber s)
	{
		this.s = s;
		
	}
	public void run()
	{
		for (int x = 10; x > 0; x--)
		{
			System.out.println(this.getName() + " Count " + x + "| " + s.getSequenceNumber());
			new counter(s).run();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println("Something went wrong");
			}
		}
	}
}
