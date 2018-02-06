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
public abstract class Person
{
	protected String  firstName,
			    	lastName,
					email;
	
	public Person()
	{
		firstName = "";
		lastName = "";
		email = "";
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + firstName + " " + lastName + "\nEmail: " + email;
	}
	
	public abstract String getDisplayText();
	
}
