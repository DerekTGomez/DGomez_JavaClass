/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: management company class that manages properties

 * Due: 11/13/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */
public class ManagementCompany {

	// MAX_PROPERTY: a constant set to 5 – the max number of properties a management
	// company can have.
	static final int MAX_PROPERTY = 5;

	// MGMT_WIDTH: a constant set to 10 – the width of the management company’s plot
	static final int MGMT_WIDTH = 10;

	// MGMT_DEPTH: a constant set to 10 – the depth of the management company’s plot
	static final int MGMT_DEPTH = 10;

	// Instance variables for ManagementCompany name, Tax Id, management fee
	// percentage.
	private String name;
	private String taxID;
	private double mgmFee;

	// Instance variable named plot of type Plot that defines the plot of the
	// management company
	private Plot plot;

	// Instance array variable named properties that stores the properties of a
	// management company
	private Property[] properties;

	// Instance variable named numberOfProperties that stores the current number of
	// properties of a management company.
	private static int numberOfProperties = 0;

	// generic fields getters

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public Plot getPlot() {
		return plot;
	}

	// Unsure of why it has the Per at the end in the instructions

	public double getMgmFeePer() {
		return mgmFee;
	}

	// constructors
	// Creates a ManagementCompany object using empty strings,
	// creates a default Plot with maximum width and depth and it initializes the
	// properties array.
	// aka no arg constructor
	public ManagementCompany() {
		name = taxID = "";
		mgmFee = 0;

		// assuming max width and depth are referring to the constants
		// assuming you're supposed to set them manually too i guess it's not really
		// clear at all
		plot = new Plot();
		plot.setDepth(MGMT_DEPTH);
		plot.setDepth(MGMT_WIDTH);

		properties = new Property[MAX_PROPERTY];
	}

	// Creates a ManagementCompany object using the given values,
	// creates a default Plot with maximum width and depth and it initializes the
	// properties array.
	public ManagementCompany(String name, String taxID, double mgmFee) {

		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;

		// same thing here, instructions to use max is unclear
		plot = new Plot();
		plot.setDepth(MGMT_DEPTH);
		plot.setDepth(MGMT_WIDTH);

		properties = new Property[MAX_PROPERTY];
	}

	// 1) Creates a ManagementCompany object using the given values
	// 2) Creates a Plot using the given values and 3) it initializes the properties
	// array.
	// This constructor should call an appropriate existing constructor.
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {

		// 1)
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;

		// 2)
		plot = new Plot(x, y, width, depth);

		// 3)
		properties = new Property[MAX_PROPERTY];

	}

	// Creates a new ManagementCompany copy of the given ManagementCompany. This
	// constructor should call an appropriate existing constructor.
	public ManagementCompany(ManagementCompany otherCompany) {

		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;

		plot = new Plot(otherCompany.plot);

		properties = new Property[MAX_PROPERTY];

		for (int i = 0; i < properties.length; i++) {
			properties[i] = new Property(otherCompany.properties[i]);
		}

	}

	// overloaded add methods

	// Adds a new property to the properties array, this method should call an
	// appropriate existing overloaded method.
	public int addProperty(Property property) {
	    if (property == null) {
	        return -2;
	    }

	    // -3 if management company does not encompass the property plot
	    if (!plot.encompasses(property.getPlot())) {
	        return -3;
	    }

	    // Check for space in the properties array
	    for (int i = 0; i < properties.length; i++) {
	        if (properties[i] == null) {
	            // Ensure no overlap before adding
	            for (int j = 0; j < numberOfProperties-1; j++) {
	                if (properties[j] != null && properties[j].getPlot().overlaps(property.getPlot())) {
	                    return -4; // Property plot overlaps
	                }
	            }

	            properties[i] = new Property(property);
	            numberOfProperties++;  // Increment number of properties
	            return i;  // Return index where the property was added
	        }
	    }

	    // If no space is found, array is full
	    return -1;
	}


	// just call the completed one
	public int addProperty(String name, String city, double rent, String owner) {
		
		Property newProperty = new Property(name, city, rent, owner);
		
		return addProperty(newProperty);
	}

	// Creates a property object by copying from another property and adds it to the
	// properties array.
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
		
		return addProperty(newProperty);
	}

	// Removes (nullifies) the LAST property in the properties array.
	public void removeLastProperty() {
		
		if (numberOfProperties > 0) {
			
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}

	// Checks if the properties array has reached the maximum capacity.
	public boolean isPropertiesFull() {
		
		return numberOfProperties == MAX_PROPERTY;
	}

	// Gets the number of existing properties in the array.
	public int getPropertiesCount() {
		
		return numberOfProperties;
	}

	// Returns the total rent of the properties in the properties array.
	public double getTotalRent() {
		
		double totalRent = 0;
		
		for (int i = 0; i < numberOfProperties; i++) {
			
			if (properties[i] != null) {
				
				totalRent += properties[i].getRentAmount();
			}
		}
		
		return totalRent;
	}

	// Gets the property in the array with the maximum amount of rent.
	public Property getHighestRentProperty() {
		
		if (numberOfProperties == 0) {
			return null; // No properties in the array
		}

		Property highestRentProperty = properties[0];
		
		for (int i = 1; i < numberOfProperties; i++) {
			
			if (properties[i] != null && properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
				highestRentProperty = properties[i];
			}
		}
		
		return highestRentProperty;
	}

	// Checks if the management company has a valid (between 0-100) fee.
	public boolean isMangementFeeValid() {
		
		
		return mgmFee >= 0 && mgmFee <= 100;
	}
	
	
	
	
	public String toString () {
		
		
		String theString = ("List of the properties for " + name + ", taxID: "  + taxID +"\n______________________________________________________\n");
		for (int i = 0; i < properties.length; i++) {
		 if (properties[i] != null) {
			 theString += properties[i].toString() + "\n";
			 
		 }
		}
		theString += "______________________________________________________\n\n total management Fee: " + (mgmFee * numberOfProperties);
		return theString;
	}

}
