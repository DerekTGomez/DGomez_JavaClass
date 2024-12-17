/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: BevShopDriver that incorporates Order and Customer usage within BevShop

 * Due: 12/16/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */

import java.util.Scanner;

public class BevShopDriverApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		BevShop shop = new BevShop();

		boolean keepRunning = true;

		while (keepRunning) {

			System.out.println("Welcome to BevShop!");

			System.out.println("Would you like to start a new order? (yes/no)");
			String newOrderInput = scanner.nextLine().trim().toLowerCase();

			if (newOrderInput.equals("yes")) {

				boolean validTime = false;

				int time = 0;

				while (!validTime) {
					try {
						System.out.println("Please enter the order time (8 to 23):");
						time = Integer.parseInt(scanner.nextLine().trim());

						if (shop.isValidTime(time)) {
							validTime = true;
						} else {
							System.out.println("Invalid time. Please enter a time between 8 and 23.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a numeric time.");
					}
				}

				boolean validDay = false;

				Day day = null;

				while (!validDay) {
					System.out.println("Please enter the day (e.g., MONDAY, TUESDAY, etc.):");
					String dayInput = scanner.nextLine().trim().toUpperCase();

					if (dayInput.equals("MONDAY")) {
						day = Day.MONDAY;
						validDay = true;
					} else if (dayInput.equals("TUESDAY")) {
						day = Day.TUESDAY;
						validDay = true;
					} else if (dayInput.equals("WEDNESDAY")) {
						day = Day.WEDNESDAY;
						validDay = true;
					} else if (dayInput.equals("THURSDAY")) {
						day = Day.THURSDAY;
						validDay = true;
					} else if (dayInput.equals("FRIDAY")) {
						day = Day.FRIDAY;
						validDay = true;
					} else if (dayInput.equals("SATURDAY")) {
						day = Day.SATURDAY;
						validDay = true;
					} else if (dayInput.equals("SUNDAY")) {
						day = Day.SUNDAY;
						validDay = true;
					} else {
						System.out.println("Invalid day. Please enter a valid day of the week.");
					}
				}

				System.out.println("Please enter your name:");
				String customerName = scanner.nextLine().trim();

				boolean validAge = false;

				int customerAge = 0;

				while (!validAge) {
					try {
						System.out.println("Please enter your age:");
						customerAge = Integer.parseInt(scanner.nextLine().trim());
						validAge = true;
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a numeric age.");
					}
				}
				
				shop.startNewOrder(time, day, customerName, customerAge);

				boolean orderComplete = false;

				while (!orderComplete) {
					
					System.out.println("The total order for now is : $" + shop.getCurrentOrder().calcOrderTotal());
					System.out.println("The total drinks for now is : " + shop.getCurrentOrder().getTotalItems());
					
					
					System.out.println("Would you like to add a beverage to your order? (yes/no)");
					String addBeverage = scanner.nextLine().trim().toLowerCase();

					if (addBeverage.equals("yes")) {
						System.out.println("What type of beverage would you like to add? (COFFEE, SMOOTHIE, ALCOHOL):");
						String beverageType = scanner.nextLine().trim().toUpperCase();

						if (beverageType.equals("COFFEE")) {

							System.out.println("Enter beverage name:");
							String bevName = scanner.nextLine().trim();
							
							System.out.println("Enter size (SMALL, MEDIUM, LARGE):");
							String sizeInput = scanner.nextLine().trim().toUpperCase();
							
							Size size = null;

							if (sizeInput.equals("SMALL")) {
								size = Size.SMALL;
							} else if (sizeInput.equals("MEDIUM")) {
								size = Size.MEDIUM;
							} else if (sizeInput.equals("LARGE")) {
								size = Size.LARGE;
							} else {
								System.out.println("Invalid size. Defaulting to SMALL.");
								size = Size.SMALL;
							}

							System.out.println("Add extra shot? (true for yes / false):");
							boolean extraShot = Boolean.parseBoolean(scanner.nextLine().trim());
							System.out.println("Add extra syrup? (true/false):");
							boolean extraSyrup = Boolean.parseBoolean(scanner.nextLine().trim());
							
							shop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);

						} else if (beverageType.equals("SMOOTHIE")) {

							System.out.println("Enter beverage name:");
							String bevName = scanner.nextLine().trim();

							System.out.println("Enter size (SMALL, MEDIUM, LARGE):");
							String sizeInput = scanner.nextLine().trim().toUpperCase();

							Size size = null;

							if (sizeInput.equals("SMALL")) {
								size = Size.SMALL;
							} else if (sizeInput.equals("MEDIUM")) {
								size = Size.MEDIUM;
							} else if (sizeInput.equals("LARGE")) {
								size = Size.LARGE;
							} else {
								System.out.println("Invalid size. Defaulting to SMALL.");
								size = Size.SMALL;
							}

							System.out.println("Enter number of fruits:");
							int numOfFruits = Integer.parseInt(scanner.nextLine().trim());
							
							
							
							
							
							System.out.println("Add protein? (true/false):");
							boolean addProtein = Boolean.parseBoolean(scanner.nextLine().trim());
							
try {
							shop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
}
catch (Exception e) {
	System.out.println("Error: " + e.getMessage());
}
						} else if (beverageType.equals("ALCOHOL")) {

							
							if (!shop.isValidAge(customerAge)) {
								
								System.out.println("You're too young!");
								scanner.nextLine();
								
							}
							else {
							System.out.println("Enter beverage name:");
							String bevName = scanner.nextLine().trim();

							System.out.println("Enter size (SMALL, MEDIUM, LARGE):");
							String sizeInput = scanner.nextLine().trim().toUpperCase();

							Size size = null;

							if (sizeInput.equals("SMALL")) {
								size = Size.SMALL;
							} else if (sizeInput.equals("MEDIUM")) {
								size = Size.MEDIUM;
							} else if (sizeInput.equals("LARGE")) {
								size = Size.LARGE;
							} else {
								System.out.println("Invalid size. Defaulting to SMALL.");
								size = Size.SMALL;
							}
try {
							shop.processAlcoholOrder(bevName, size);
}
catch (Exception e) {
	System.out.println("Error: " + e.getMessage());
}
							}
						} else {
							System.out.println("Invalid beverage type.");
						}

					} else if (addBeverage.equals("no")) {
						orderComplete = true;
					} else {
						System.out.println("Invalid input. Please enter 'yes' or 'no'.");
						scanner.nextLine();
					}
				}
				 System.out.println("The Total Price on the Order: $" + shop.getCurrentOrder().calcOrderTotal());
				System.out.println("Order completed.");

			} else if (newOrderInput.equals("no")) {
				keepRunning = false;
			} else {
				System.out.println("Invalid input. Please enter 'yes' or 'no'.");
			}
		}

		System.out.println("Thank you for visiting BevShop!");

		System.out.println("#------------------------------------#");
        System.out.println("Total Monthly Sale: " + shop.totalMonthlySale());
		
        System.out.println("toString: " + shop.toString());
        
		scanner.close();
	}
}
