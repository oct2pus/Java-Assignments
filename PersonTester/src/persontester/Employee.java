/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontester;

/**
 *
 * @author Austin LaBerta
 */
public class Employee extends Person
{

	protected String phoneNumber;
	
	Employee()
	{
		String firstName = "";
		String lastName = "";
		String email = "";
		String phoneNumber = "";
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String getDisplayText()
	{
		return toString() + "\nPhone Number: " + phoneNumber;
	}
	
}
