/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Alcohol subclass for Beverage

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */

public class Alcohol extends Beverage {

	// Contains an additional instance variable for whether or not the beverage is offered on the weekend.
	// The additional cost for drinks offered on the weekend is $0.60.

	private boolean isWeekend;
	private final double WEEKEND_COST = 0.60;

	// A parameterized constructor
	Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	// Indicates whether or not the beverage is offered on the weekend
	public boolean isWeekend() {
		return this.isWeekend;
	}

	// Calculates the price of the alcohol beverage based on base price, size, and whether it's offered on the weekend
	@Override
	public double calcPrice() {
		double price = this.addSizePrice();

		// Add weekend cost if applicable
		if (this.isWeekend) {
			price += WEEKEND_COST;
		}

		return price;
	}

	// Represents an Alcohol beverage in the following String format:
	// name,size,whether it is offered in the weekend,price
	@Override
	public String toString() {
		return this.getBevName() + "," + this.getSize() + "," + this.isWeekend + "," + this.calcPrice();
	}

	// Checks equality based on the Beverage class equals method and additional instance variables for this class
	@Override
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Alcohol) {
			Alcohol temp = (Alcohol) anotherBev;

			// Explicitly call the equals method from the Beverage class
			if (super.equals(temp) && this.isWeekend == temp.isWeekend) {
				return true;
			}
		}
		return false;
	}
}
