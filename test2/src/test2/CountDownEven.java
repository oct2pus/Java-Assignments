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
public class CountDownEven extends Thread {
	@Override
	public void run()
	{
		for (int i = 10; i > 0; i-=2)
		{
			System.out.println(this.getName() + " Count " + i);
		}
	}
}
