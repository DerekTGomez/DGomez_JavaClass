/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: order implementation that manages an order

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */


import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{

	// Instance variables for order number, order time, order day and customer and a list of beverages within this order

	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages = new ArrayList<>();
	
	
	
	
	// for generateOrder
	private final int ORDER_NUM_MIN = 10000;
	private final int ORDER_NUM_LIMIT = 90001;
	
	
	
	//A parametrized constructor 

	public Order(int orderTime, Day orderDay, Customer cust) {
		
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		//deep copy using copy constructor 
		this.cust = new Customer(cust);
		
		this.orderNumber = generateOrder();
		
	}
	
	
	
	
	
	
	// Automatically generate order number
	public int generateOrder() {
		Random rand = new Random();
		
		int orderNumber = 0;
		
		
		//a random order number between 10000 and 90000
		orderNumber = rand.nextInt(ORDER_NUM_MIN, ORDER_NUM_LIMIT);
		
		return orderNumber;
	} 	
	
	// returns the order number... 
// javadoc is wrong here i think
	public int getOrderNo() {
		
		return this.orderNumber;
		
	}

	
	
	// returns the order time
	public int getOrderTime() {
		
		return this.orderTime;
	}

	// returns the order day
	public Day getOrderDay() {
		return this.orderDay;
	}

	// returns the customer
	// Note: The getter method for the customer returns a Deep copy of the customer.
	public Customer getCustomer() {
	
		Customer temp = new Customer(this.cust);
		return temp;
	}

	
	


	
// true if the order day is a weekend day (Saturday or Sunday)

	@Override
	public boolean isWeekend() {
		
		if (this.orderDay.equals(Day.SATURDAY)) {
			
			return true;
		}
		
        if (this.orderDay.equals(Day.SUNDAY)) {
			
			return true;
		}
		
		
		return false;
	}

	
	// returns the beverage listed in the itemNo of the order, 
	// for example if itemNo is 0 this method will return the first beverage in this order 
	// Note: this method returns the shallow copy of the Beverage

	@Override
	public Beverage getBeverage(int itemNo) {
        
		// null if there is no item in the order
		if (beverages.size() == 0) {
			return null;
		}
		
		
		
		if ((itemNo >= 0) && (itemNo < beverages.size())) {
           
			
			return beverages.get(itemNo);
        }
        
		return null; // Return null if itemNo is invalid
    }
	
	//returns the total number of beverages ordered within this order
	 public int getTotalItems() {
	        
		 
		 return beverages.size();
	    }

	
	
	// addBeverages
	  
	// coffee add new
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		 beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
		
	}
	
	// Alcohol add new
	@Override
	public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
		
	}

	
	//  smoothie add new
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		 
	}

	//Calculates and returns the total amount for this order
	@Override
	public double calcOrderTotal() {
	
		
		double total = 0.0;
        for (Beverage bev : beverages) {
            
        	//polymorphism!!
        	total += bev.calcPrice();
        }
        return total;
		
	}

	
	
	//returns the number of beverages of same type in an order

	@Override
	public int findNumOfBeveType(Type type) {
		
		
		int count = 0;
       
		
		for (Beverage bev : beverages) {
           
        	// each constructor for the drink subclasses calls the super with their own type
			// therefore each beverage has it's type as a beverage, not the specific drink
			// so technically not polymorphism?
        	
        	if (bev.getType() == type) {
            
        		
        		count++;
            
        	
        	
        	}
        }
        return count;
	}

//	Override the compareTo method to compare this order with another order based on the order number. 
	@Override
	public int compareTo(Order o) {

		int result = 0;
		

		
		
		result = (this.orderNumber - o.orderNumber);
		
		
//		Returns 0 if this order number is same as another order's order number,
		if (result == 0) {
			return 0;
		}
//		1 if it is greater than another order's order number,
		if(result > 0) {
			return 1;
		}
//		-1 if it smaller than another order's order number.
		if(result < 0) {
			return -1;
		}
		
		//how
		return 999999;
	}
	
	
	// String representation of the order, Includes order number, time , day, customer name and age and the list of beverages
	public String toString() {
		
		String stringson = "";
		
      for (Beverage bev : beverages) {
            
        	//polymorphism!!
        	stringson = (stringson + "," + bev.toString());
        }
		
		return (this.orderNumber + "," + this.orderTime + "," + this.orderDay + "," + cust.toString() + stringson);
		
		
	}

	
	

}
