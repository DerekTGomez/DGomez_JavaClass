/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: SAVINGS ACCOUNT EXTENDER OF BANKACCOUNT

 * Due: 11/23/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */






public class SavingsAccount extends BankAccount{

	
	// an instance variable called rate that represents the annual interest rate. Set it equal to 2.5%
	
	private double rate = 0.025;
	
	
	//It should also have an instance variable called savingsNumber, initialized to 0
	private int savingsNumber = 0;
	
	// An instance variable called accountNumber that will hide the accountNumber from the superclass, should also be in this class
	
	private String accountNumber;
	
	
	// Write a constructor that takes a name and an initial balance as parameters and calls the constructor for the superclass
	
	public SavingsAccount (String name, double amount) {
		
		super(name, amount);
		
		// It should initialize accountNumber to be the current value in the superclass accountNumber
		// concatenated with a hyphen and then the savingsNumber
		this.accountNumber = (super.getAccountNumber() + "-" + savingsNumber);
	}
	
	// Write a method called postInterest that has no parameters and returns no value
	
	public void postInterest () {
		
		// This method will calculate one month's worth of interest on the balance and deposit it into the account
		
		
		// assuming no compound interest formula and just flat rate
		double month = rate / 12;
		
		
		month = this.getBalance() * month;
		
		
		this.deposit(month);
		
		
		
	}
	
	
	// Write a method that overrides the getAccountNumber method in the superclass
	
	@Override
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	
	
	// Write a copy constructor that creates another savings account for the same person. 
	// It should take the original savings account and an initial balance as parameters
	
	public SavingsAccount (SavingsAccount original, double balance) {
		 
		
		//It should call the copy construcstor of the superclass
		super(original, balance);
		
		// assign the savingsNumber to be one more than the savingsNumber of the original savings account
		this.savingsNumber = original.savingsNumber + 1;
		
		// It should assign the accountNumber to be the accountNumber of the superclass 
		// (the hidden instance variable) concatenated with the hypen and the savingsNumber of the new account
		
		accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
		
	}
	
	
}
