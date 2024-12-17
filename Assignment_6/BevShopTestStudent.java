import static org.junit.Assert.*;

import java.util.InputMismatchException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    BevShop shop;

    @Before
    public void setUp() throws Exception {
        shop = new BevShop();
    }

    @After
    public void tearDown() throws Exception {
        shop = null;
    }

    @Test
    public void testIsValidTime() {
        System.out.println("TESTING: testIsValidTime");
        System.out.println();

        assertTrue(shop.isValidTime(10)); // Expected: true
        System.out.println("Time 10 is valid: true");

        assertFalse(shop.isValidTime(24)); // Expected: false
        System.out.println("Time 24 is valid: false");

        assertFalse(shop.isValidTime(7)); // Expected: false
        System.out.println("Time 7 is valid: false");

        System.out.println("testIsValidTime ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test
    public void testGetMaxNumOfFruits() {
        System.out.println("TESTING: testGetMaxNumOfFruits");
        System.out.println();

        assertEquals(5, shop.getMaxNumOfFruits()); // Expected: 5
        System.out.println("Max number of fruits: 5");

        System.out.println("testGetMaxNumOfFruits ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test
    public void testIsMaxFruit() {
        System.out.println("TESTING: testIsMaxFruit");
        System.out.println();

        assertTrue(shop.isMaxFruit(6)); // Expected: true
        System.out.println("6 fruits is max: true");

        assertFalse(shop.isMaxFruit(3)); // Expected: false
        System.out.println("3 fruits is max: false");

        System.out.println("testIsMaxFruit ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test
    public void testIsValidAge() {
        System.out.println("TESTING: testIsValidAge");
        System.out.println();

        assertTrue(shop.isValidAge(21)); // Expected: true
        System.out.println("Age 21 is valid: true");

        assertFalse(shop.isValidAge(17)); // Expected: false
        System.out.println("Age 17 is valid: false");

        System.out.println("testIsValidAge ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test
    public void testStartNewOrder() {
        System.out.println("TESTING: testStartNewOrder");
        System.out.println();

        shop.startNewOrder(9, Day.MONDAY, "Alice", 25); // Valid order
        System.out.println("New order created: Alice, Age 25, Time 9, Day MONDAY");

        assertNotNull(shop.getCurrentOrder()); // Expected: not null
        System.out.println("Current order is not null: true");

        shop.startNewOrder(7, Day.SUNDAY, "Bob", 30); // Invalid time
        System.out.println("Attempted order at invalid time 7: Expecting Store is closed message.");

        System.out.println("testStartNewOrder ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test(expected = InputMismatchException.class)
    public void testProcessAlcoholOrder() {
        System.out.println("TESTING: testProcessAlcoholOrder");
        System.out.println();

        shop.startNewOrder(10, Day.FRIDAY, "Charlie", 28);
        shop.processAlcoholOrder("Whiskey", Size.LARGE);
        System.out.println("Processed 1st alcohol order: Whiskey, Size LARGE");

        shop.processAlcoholOrder("Vodka", Size.SMALL);
        System.out.println("Processed 2nd alcohol order: Vodka, Size SMALL");

        shop.processAlcoholOrder("Rum", Size.MEDIUM);
        System.out.println("Processed 3rd alcohol order: Rum, Size MEDIUM");

        shop.processAlcoholOrder("Tequila", Size.LARGE); // Exceeds limit, exception expected
        System.out.println("Processed 4th alcohol order: Expecting exception");

        System.out.println("testProcessAlcoholOrder ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test(expected = InputMismatchException.class)
    public void testProcessSmoothieOrder() {
        System.out.println("TESTING: testProcessSmoothieOrder");
        System.out.println();

        shop.startNewOrder(12, Day.TUESDAY, "David", 20);
        shop.processSmoothieOrder("Berry Blast", Size.MEDIUM, 3, true);
        System.out.println("Processed smoothie order: Berry Blast, Size MEDIUM, Fruits 3, Protein true");

        shop.processSmoothieOrder("Fruit Fiesta", Size.LARGE, 6, false); // Exceeds fruit limit
        System.out.println("Processed smoothie order: Expecting exception");

        System.out.println("testProcessSmoothieOrder ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test
    public void testTotalMonthlySale() {
        System.out.println("TESTING: testTotalMonthlySale");
        System.out.println();

        shop.startNewOrder(9, Day.MONDAY, "Alice", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        shop.processAlcoholOrder("Wine", Size.MEDIUM);

        shop.startNewOrder(11, Day.FRIDAY, "Bob", 30);
        shop.processSmoothieOrder("Tropical", Size.LARGE, 2, true);

        double totalSale = shop.totalMonthlySale();
        System.out.println("Total monthly sale: " + totalSale); // Expected: Sum of all orders

        assertTrue(totalSale > 0);
        System.out.println("Total sale is greater than 0: true");

        System.out.println("testTotalMonthlySale ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }

    @Test
    public void testFindOrder() {
        System.out.println("TESTING: testFindOrder");
        System.out.println();

        shop.startNewOrder(10, Day.THURSDAY, "Emma", 22);
        int orderNo = shop.getCurrentOrder().getOrderNo();

        int index = shop.findOrder(orderNo);
        System.out.println("Order found at index: " + index); // Expected: valid index
        assertEquals(0, index);

        shop.startNewOrder(10, Day.THURSDAY, "John", 22);
        int orderHERE = shop.getCurrentOrder().getOrderNo();
        shop.startNewOrder(10, Day.THURSDAY, "Carlos", 22);
        
        assertEquals(shop.getOrderAtIndex(1).getOrderNo(), orderHERE);
        System.out.println("Order at index 1 is correct order");
        
        int invalidIndex = shop.findOrder(9999);
        System.out.println("Order not found, returned index: " + invalidIndex); // Expected: -1
        assertEquals(-1, invalidIndex);

        System.out.println("testFindOrder ENDED");
        System.out.println("----------------------------");
        System.out.println();
    }
}
