/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Coffee subclass of beverage

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */



public class Coffee extends Beverage {
	
	
	
	// Contains additional instance variables of type boolean to indicate if it contains extra shot of coffee (additional cost of 50 cents)
	// and extra syrup (additional cost of 50 cents)
	
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_PRICE = 0.5;
	private final double SYRUP_PRICE = 0.5;
	
	
	// A parametrized constructor
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		
		super(bevName, Type.COFFEE, size);
	
	this.extraShot = extraShot;
	this.extraSyrup = extraSyrup;
		
	}
	
	// Indicates whether or not extra shot is added
	public boolean getExtraShot() {
		
		return this.extraShot;
		
	}
	
	//Indicates whether or not extra syrup is added
	public boolean getExtraSyrup() {
		return this.extraSyrup;
	}
	
	//Calculates the price based on base price, size, extra coffee shot and extra syrup
	public double calcPrice() {
		
		double price = this.addSizePrice();
		
		if (this.extraShot) {
			
			price += SHOT_PRICE;
			
		}
		
		if (this.extraSyrup) {
			
			price += SYRUP_PRICE;
			
		}
		
		
		
		return price;
		
	}
	
	
	//Represents a Coffee beverage in the following String format: name,size, whether it contains extra shot, extra syrup and the price

	public String toString() {
		
		
		return (this.getBevName() + "," + this.getSize( )+ "," + this.extraShot + "," + this.extraSyrup + "," + this.calcPrice());
		
		
	
	}
	

	
	// true if the name, type, size and base price and whether or not it contains extra shot and extra syrup false otherwise
	@Override
	public boolean equals(Object anotherBev) {
		

		if ( anotherBev instanceof Coffee) {
			
			Coffee temp = (Coffee) anotherBev;
			
			
			
			if (this.getBevName().equals(temp.getBevName()) && this.getType().equals(temp.getType()) && this.getSize().equals(temp.getSize())
					&& (this.extraShot == temp.extraShot) && (this.extraSyrup == temp.extraSyrup)) {
				
				return true;
				
			}
			
			
			
			
			
			
		}
		

		
		
		
		return false;
		
	}
	
	
	
	
	
	
}