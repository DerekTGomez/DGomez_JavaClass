/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: CHECKING ACCOUNT EXTENDER OF BANKACCOUNT

 * Due: 11/23/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */
public class CheckingAccount extends BankAccount{

	static final double FEE = 0.15;
	
	
	 // Write a constructor that takes a name and an initial amount as parameters
	
	public CheckingAccount (String name, double amount) {
		
        // It should call the constructor for the superclass
		super(name, amount);
		
		//It should initialize accountNumber to be the current value in accountNumber concatenated with –10
		this.setAccountNumber(super.getAccountNumber()  + "-10");
		
		
		
	}
	
	
	
	
	// a new instance method, withdraw, that overrides the withdraw method in the superclass
	@Override
	public boolean withdraw (double amount) {
		
		
		// take the amount to withdraw, add to it the fee for check clearing, and call the withdraw method from the superclass
		
		amount += FEE;
		return super.withdraw(amount);
	}
	
	
	
	
	
	
	
	
	
	
}
