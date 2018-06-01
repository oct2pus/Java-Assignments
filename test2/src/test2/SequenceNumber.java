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

public class SequenceNumber {
	
	private int i;
	
	public SequenceNumber()
	{
		i = 0;
	}
	
	public int getSequenceNumber() 
	{
		return ++i;
	}
}
