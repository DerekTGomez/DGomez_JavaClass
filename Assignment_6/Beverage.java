/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Beverage superclass for drinks

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */
public abstract class Beverage {

	//Instance variables for beverage name, beverage type, size, and constant attributes for the base price ($2.0)
	// and size price (additional $0.5 to go a size up)

	private String bevName;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 0.5;


	//Creates a beverage object using given values.

	public Beverage(String bevName, Type type, Size size) {


		this.bevName = bevName;
		this.type = type;
		this.size = size;



	}


	// Gets the base price
	public double getBasePrice() {
		return BASE_PRICE;
	}


	// Gets beverage type
	public Type getType() {
		return this.type;
	}



	// Gets the name of the beverage
	public String getBevName() {
		return this.bevName;
	}


	// Gets the size of the beverage
	public Size getSize() {
		return this.size;
	}


	// Calculates a new price by adding the size price to the base price.
	// There is no additional cost for small size,
	// for medium and large beverages the additional cost of size price is added to base price
	//For example if the base price is 2 and SIZE_PRICE is .5 then the cost of small beverage is 2, the medium beverage is 2.5 and the large beverage is 3.

	public double addSizePrice() {

		double price = BASE_PRICE;

		if (this.size.equals(Size.LARGE)) {

			price += SIZE_PRICE;
			price += SIZE_PRICE;

		}


		else if (this.size.equals(Size.MEDIUM)) {

			price += SIZE_PRICE;

		}



		return price;
	}


	// String representation for Beverage including the name and size
	public String toString() {

		// Represents a Beverage object in String with the format of bevName,size

		return (this.bevName + "," + this.size);

	}



	//Checks if this Beverage equals to anotherBev

	@Override
	public boolean equals(Object anotherBev) {

		// true if the name, type, size , false otherwise
		//            string type  size
		if (anotherBev instanceof Beverage) {

			Beverage temp = (Beverage) anotherBev;


			if (this.bevName.equals(temp.bevName) && this.type.equals(temp.type) && this.size.equals(temp.size)) {

				return true;

			}



		}



		return false;

	}



	// Calculates the beverage price

	public abstract double calcPrice();





}
