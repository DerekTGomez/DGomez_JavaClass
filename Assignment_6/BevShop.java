/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: BevShop that implements it's interface and uses Order

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */

import java.util.ArrayList;
import java.util.InputMismatchException;






public class BevShop implements BevShopInterface {


	public ArrayList<Order> orders = new ArrayList<>();


	private Order currentOrder;




// default Constructor Initializes a BevShop Object

	public BevShop() {


		orders = new ArrayList<>();




	}









	// Checks if the time is valid (between 8 and 23 )

	@Override
	public boolean isValidTime(int time) {

// true if times is within the range of 8 to 23 , false otherwise


		if ((time >= 8) && (time <= 23 )) {

			return true;



		}




		return false;
	}






	// returns the constant value for the maximum number of fruits
	@Override
	public int getMaxNumOfFruits() {

		return MAX_FRUIT;
	}





// returns the constant value for the Minimum age for offering Alcohol drink
	@Override
	public int getMinAgeForAlcohol() {

		return MIN_AGE_FOR_ALCOHOL;
	}




	// returns true if the passed parameter exceeds the Maximum FRUIT allowed
// personally id rename this to EXCEEDSmaxFruit
	@Override
	public boolean isMaxFruit(int numOfFruits) {

		//true if the passed parameter exceeds the MAXIUM number of fruits allowed for the SMOTHIE drink, false otherwise
		if (numOfFruits > MAX_FRUIT) {


			return true;
		}



		return false;
	}








	// returns constant maximum number of alcohol beverages/per order offered by the beverage shop
	@Override
	public int getMaxOrderForAlcohol() {

		return MAX_ORDER_FOR_ALCOHOL;
	}




	// checks if the number of alcohol beverages for the current order has reached the maximum
	// this feels like the javadoc is wrong because why would it say to be true when you are NOT elligble for more?
	@Override
	public boolean isEligibleForMore() {

		//true if number of alcohol drinks for the current order has reached the maximum , false otherwise
		return (currentOrder.findNumOfBeveType(Type.ALCOHOL) >= MAX_ORDER_FOR_ALCOHOL);

	}

	// returns the number of alcohol drinks for the current order
	@Override
	public int getNumOfAlcoholDrink() {

		return currentOrder.findNumOfBeveType(Type.ALCOHOL);

	}


	// check the valid age for the alcohol drink

	@Override
	public boolean isValidAge(int age) {

		// returns true if age is more than minimum eligible age , false otherwise


		return (age >= MIN_AGE_FOR_ALCOHOL);
	}




	// Creates a new order , NO BEVERAGE is added to the order yet

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {

		if (!this.isValidTime(time)) {

			System.out.println("Store is closed!");

		}
		else {

			Customer customer = new Customer(customerName, customerAge);
			currentOrder = new Order(time, day, customer);
			orders.add(currentOrder);

		}

	}

	// process the Coffee order for the current order by adding it to the current order

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {

		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}


	// process the Alcohol order for the current order by adding it to the current order

	@Override
	public void processAlcoholOrder(String bevName, Size size) {

		if (isEligibleForMore()) {
			throw new InputMismatchException("Too many Alcoholic drinks!!!");
		}
		currentOrder.addNewBeverage(bevName, size);

	}


	// process the Smoothie order for the current order by adding it to the current order

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {


		if (isMaxFruit(numOfFruits)) {
			throw new InputMismatchException("Too many fruits!!!");

		}
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}


	//locate an order based on the order number

	@Override
	public int findOrder(int orderNo) {

		for (int i = 0; i < orders.size(); i++) {


			if (orders.get(i).getOrderNo() == orderNo) {


				return i;

			}

		}


		// the index of the order in the list of Orders if found or -1 if not found

		return -1;
	}

	// locates an order in the list of orders and returns the total value on the order.

	@Override
	public double totalOrderPrice(int orderNo) {


		int index = findOrder(orderNo);




		if (index == -1) {

			return 0;

		}

		return orders.get(index).calcOrderTotal();
	}





	// Calculates the total sale of all the orders for this beverage shop

	@Override
	public double totalMonthlySale() {

		double total = 0.0;

		for (Order order : orders) {

			total += order.calcOrderTotal();

		}

		return total;
	}


	// returns total numbers of orders within the month

	@Override
	public int totalNumOfMonthlyOrders() {

		return orders.size();

	}

	// returns the current Order located in the index in the list of orders. Notes: this method returns the shallow copy of the order
	@Override
	public Order getCurrentOrder() {

		return currentOrder;

	}

	// returns Order in the list of orders at the index Notes: this method returns the shallow copy of the order

	@Override
	public Order getOrderAtIndex(int index) {

		if (index >= 0 && index < orders.size()) {

			return orders.get(index);

		}

		return null;
	}

	// sorts the orders by orders numbers within this bevShop using the Selection sort algorithm

	@Override
	public void sortOrders() {


		ArrayList<Order> sortedOrders = new ArrayList<>(orders);
		for (int i = 0; i < sortedOrders.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < sortedOrders.size(); j++) {
				if (sortedOrders.get(j).getOrderNo() < sortedOrders.get(minIndex).getOrderNo()) {
					minIndex = j;
				}
			}
			Order temp = sortedOrders.get(i);
			sortedOrders.set(i, sortedOrders.get(minIndex));
			sortedOrders.set(minIndex, temp);
		}
		orders = sortedOrders;
	}


	// returns the string representation of all the orders and the total monthly sale
	public String toString() {



		String worker = "";

		for (Order order : orders) {


			worker = worker + order.toString() + ",";



		}


		worker = worker + "," + totalMonthlySale();

		return worker;



	}






}
