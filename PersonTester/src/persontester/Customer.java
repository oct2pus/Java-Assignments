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
public class Customer extends Person 
{

	protected String customerNumber;
	
	public Customer()
	{
		firstName = "";
		lastName = "";
		email = "";
		customerNumber = "";
	}
	
	
	public String getCustomerNumber()
	{
		return customerNumber;
	}
	
	public void setCustomerNumber(String customerNumber)
	{
		this.customerNumber = customerNumber;
	}
	
	@Override
	public String getDisplayText()
	{
		return toString() + "\nCustomer Number: " + customerNumber;
	}
	
}
