/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Customer class for a customer

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */

public class Customer {

	 
	
	// Instance variables for name and age
	
	private String name;
	private int age;
	
	
	
	
	public Customer(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	
	// copy constructor

	public Customer(Customer c) {
		
		this.name = c.name;
		this.age = c.age;
		
		
	}
	
	
	
	
	// get method for age
	public int getAge() {
		
		return this.age;
	}

	
	
//Set method for age
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
//get method for name
	public String getName() {
		
		
		return this.name;
	}

	// set method for name
	public void setName(String name){
		
		this.name = name;
		
		
	}
	
	//String representation of the customer includes the name and age of the customer.

	@Override
	public String toString() {
		return (this.name + "," + this.age);
	}

	
	
}
