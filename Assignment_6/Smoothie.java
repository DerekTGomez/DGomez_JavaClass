/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Smoothie subclass for beverage 

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */
public class Smoothie extends Beverage {

    // Contains additional instance variables for number of fruits and a boolean variable to indicate 
    // if protein powder is added to the beverage. The cost of adding protein is $1.50, and each 
    // additional fruit costs 50 cents.
    
    private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_COST = 0.5;
    private final double PROTEIN_COST = 1.5;

    // A parameterized constructor
    Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    // Gets the number of fruits
    public int getNumOfFruits() {
        return this.numOfFruits;
    }

    // Indicates whether or not protein is added
    public boolean getAddProtein() {
        return this.addProtein;
    }

    // Calculates the price based on base price, size, number of fruits, and whether protein powder is added
    @Override
    public double calcPrice() {
        double price = this.addSizePrice();

        // Add cost for protein powder
        if (this.addProtein) {
            price += PROTEIN_COST;
        }

        // Add cost for additional fruits
        price += (this.numOfFruits * FRUIT_COST);

        return price;
    }

    // Represents a Smoothie beverage in the following String format: 
    // name,size,number of fruits,whether protein powder is added,price
    @Override
    public String toString() {
        return this.getBevName() + "," + this.getSize() + "," + this.numOfFruits + "," 
                + this.addProtein + "," + this.calcPrice();
    }

    // Checks equality based on the Beverage class equals method and additional instance variables for this class
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Smoothie) {
            Smoothie temp = (Smoothie) anotherBev;

            //  call the equals method from the Beverage class 
            if (super.equals(temp) && this.numOfFruits == temp.numOfFruits 
                    && this.addProtein == temp.addProtein) {
                return true;
            }
        }
        return false;
    }
}
