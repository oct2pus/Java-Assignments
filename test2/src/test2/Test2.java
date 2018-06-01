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
public class Test2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Thread t1, t2, t3, t4, t5;
		SequenceNumber s =  new SequenceNumber();
		t1 = new counter(s);
		t2 = new counter(s);
		t3 = new counter(s);
		t4 = new counter(s);
		t5 = new counter(s);
		t1.run();
		t2.run();
		t3.run();
		t4.run();
		t5.run();
		
	}
	
}
