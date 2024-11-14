/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: property class aggregate methods

 * Due: 11/13/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */

public class Property {

	// fields: Instance variables for property name, city, rental amount, owner, and
	// plot.
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;

	// getters

	public String getPropertyName() {

		return propertyName;
	}

	public String getCity() {

		return city;
	}

	public String getOwner() {

		return owner;
	}

	public double getRentAmount() {

		return rentAmount;
	}

	public Plot getPlot() {

		return plot;
	}

	// google doc says make setters even though html doesnt so i did either ways

	public void setPropertyName(String s) {
		propertyName = s;
	}

	public void setCity(String s) {
		city = s;
	}

	public void setOwner(String s) {
		owner = s;
	}

	public void setPlot(Plot p) {
		plot = new Plot(p);
	}

	public void setRentAmount(double d) {
		rentAmount = d;
	}

	// constructors

	// Creates a new Property using empty strings. It also creates a default Plot
	public Property() {

		propertyName = city = owner = "";
		rentAmount = 0;
		plot = new Plot();
	}

	// Creates a new Property object using given values. It also creates a default
	// Plot.
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;

		// default
		plot = new Plot();
	}

	// Creates a new Property object using given values. It also creates a Plot
	// using given values of a plot.
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;

		plot = new Plot(x, y, width, depth);
	}

	// Creates a new copy of the given property object
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;

		this.plot = new Plot(otherProperty.plot);
	}

	public String toString() {

		return (this.propertyName + "," + this.city + "," + this.owner + "," + this.rentAmount);
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Property) {

			Property temp = (Property) o;

			return (propertyName.equals(temp.propertyName) && city.equals(temp.city) && owner.equals(temp.owner)
					&& rentAmount == temp.rentAmount);
		}
		return false;
	}

}
