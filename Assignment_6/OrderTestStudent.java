import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    Order orderOne, orderTwo, orderThree;

    @Before
    public void setUp() throws Exception {
        orderOne = new Order(9, Day.MONDAY, new Customer("Alice", 25));
        orderTwo = new Order(15, Day.SATURDAY, new Customer("Bob", 30));
        orderThree = new Order(12, Day.WEDNESDAY, new Customer("Charlie", 18));
    }

    @After
    public void tearDown() throws Exception {
        orderOne = orderTwo = orderThree = null;
    }

    @Test
    public void testGenerateOrder() {
        int orderNumOne = orderOne.generateOrder();
        int orderNumTwo = orderTwo.generateOrder();

        // Ensure the order numbers are within the valid range
        assertTrue(orderNumOne >= 10000 && orderNumOne < 100000);
        assertTrue(orderNumTwo >= 10000 && orderNumTwo < 100000);
        
        orderNumTwo = orderNumOne;
        
        orderNumOne = orderOne.generateOrder();
        
        
        assertNotEquals(orderNumOne, orderNumTwo); // Should generate unique numbers
    }

    @Test
    public void testGetOrderTime() {
       
    	 System.out.println("TESTING       \n" );
    	
    	assertEquals(9, orderOne.getOrderTime());
        assertEquals(15, orderTwo.getOrderTime());
        
        
        System.out.println("ENDING       \n" );
    }

    @Test
    public void testGetOrderDay() {
        
    	System.out.println("TESTING       \n" );
    	
    	assertEquals(Day.MONDAY, orderOne.getOrderDay());
        assertEquals(Day.SATURDAY, orderTwo.getOrderDay());
        
        System.out.println("ENDING       \n" );
        
        
    }

    @Test
    public void testGetCustomer() {
    	
    	
    	System.out.println("TESTING       \n" );
    	
    	
        Customer customerCopy = orderOne.getCustomer();
        assertEquals("Alice", customerCopy.getName());
        assertEquals(25, customerCopy.getAge());

        // Ensure deep copy by modifying the original and checking the copy
        orderOne.getCustomer().setName("Modified");
        assertEquals("Alice", customerCopy.getName());
        
        System.out.println("ENDING       \n" );
    }

    @Test
    public void testIsWeekend() {
    	System.out.println("TESTING       \n" );
    	
        assertFalse(orderOne.isWeekend()); // monday
        assertTrue(orderTwo.isWeekend()); // saturday
        assertFalse(orderThree.isWeekend()); // wednesday 
        
        System.out.println("ENDING       \n" );
    }

    @Test
    public void testAddNewBeverage() {
       
    	System.out.println("TESTING       \n" );
    	
    	orderOne.addNewBeverage("Latte", Size.SMALL, true, false);
        orderOne.addNewBeverage("Whiskey", Size.LARGE);
        orderOne.addNewBeverage("Berry Smoothie", Size.MEDIUM, 3, true);

        assertEquals(3, orderOne.getTotalItems());
        assertEquals(Type.COFFEE, orderOne.getBeverage(0).getType());
        assertEquals(Type.ALCOHOL, orderOne.getBeverage(1).getType());
        assertEquals(Type.SMOOTHIE, orderOne.getBeverage(2).getType());
    
        System.out.println("ENDING       \n" );
    
    
    }

    @Test
    public void testGetBeverage() {
       
    	System.out.println("TESTING       \n" );
    	
    	orderTwo.addNewBeverage("Cappuccino", Size.MEDIUM, false, true);
        Beverage bev = orderTwo.getBeverage(0);

        assertNotNull(bev);
        assertEquals("Cappuccino", bev.getBevName());
        assertEquals(Size.MEDIUM, bev.getSize());

        assertNull(orderTwo.getBeverage(5)); // Invalid index
        
        
        
        System.out.println("ENDING       \n" );
    }

    @Test
    public void testFindNumOfBeveType() {
       
    	System.out.println("TESTING       \n" );
    	
    	orderThree.addNewBeverage("Espresso", Size.SMALL, false, false);
        orderThree.addNewBeverage("Rum", Size.MEDIUM);
        orderThree.addNewBeverage("Green Smoothie", Size.LARGE, 2, false);

        assertEquals(1, orderThree.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, orderThree.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, orderThree.findNumOfBeveType(Type.SMOOTHIE));
        
        
        
        System.out.println("ENDING       \n" );
    }

    @Test
    public void testCalcOrderTotal() {
       
    	System.out.println("TESTING       \n" );
    	
    	orderOne.addNewBeverage("Latte", Size.SMALL, false, true); // 2 + 0 + 0 + (SYRUP) 0.5
        orderOne.addNewBeverage("Vodka", Size.SMALL); // 2 + 0 + NOT WEEKENED (0)
        orderOne.addNewBeverage("Protein Smoothie", Size.MEDIUM, 2, true); // 2 + 0.5 + (FRUIT) 1.0 + (PROTEIN) 1.5

        double expectedTotal = 2.5 + 2.0 + 5.0; 
        assertEquals(expectedTotal, orderOne.calcOrderTotal(), 0.01);
        
        
        
        orderTwo.addNewBeverage("Johnny's", Size.LARGE); // 2.0 + weekend (0.6) + 1.0
        
        
        expectedTotal = 3.6;
        
        assertEquals(expectedTotal, orderTwo.calcOrderTotal(), 0.01);
        
        System.out.println("ENDING       \n" );

    }

    @Test
    public void testCompareTo() {
       
    	
    	System.out.println("TESTING       \n" );
    	
    	
    	int compareResult = orderOne.compareTo(orderTwo);

        System.out.println("Order number One: " + orderOne.getOrderNo());
        System.out.println("Order number Two: " + orderTwo.getOrderNo());
        System.out.println(compareResult);
        
        if (orderOne.compareTo(orderTwo) == 1) {
        	
        	assertTrue( orderOne.getOrderNo() >  orderTwo.getOrderNo());
  
        }
        else if (orderOne.compareTo(orderTwo) == 0) {
        	
        	assertTrue( orderOne.getOrderNo() ==  orderTwo.getOrderNo());
        	
        } 
        else if (orderOne.compareTo(orderTwo) == -1) {
        	
        	
        	assertTrue( orderOne.getOrderNo() <  orderTwo.getOrderNo());
        	
        }
        else {
        	assertTrue(false);
        }
        
        
       System.out.println(compareResult);
       System.out.println("ENDING       \n" );
    }

    @Test
    public void testToString() {
       
    	System.out.println("TESTING       \n" );
    	
    	
    	orderOne.addNewBeverage("Americano", Size.LARGE, false, false);
        orderOne.addNewBeverage("Tequila", Size.SMALL);
        String result = orderOne.toString();

       String nomner = "" + orderOne.getOrderNo();
        
        
        System.out.println(orderOne.toString());
        
        
        assertTrue(result.contains("Americano"));
        assertTrue(result.contains("Tequila"));
        assertTrue(result.contains("Alice"));
        
        //ordernum,time,day,custName,age,bevName,size,coffeefalse,coffeefalse,drinkprice,bevname,size,mondayFalse,drinkprice
        assertEquals((nomner + ",9,MONDAY,Alice,25,Americano,LARGE,false,false,3.0,Tequila,SMALL,false,2.0"), result);
        
        System.out.println("ENDING       \n" );
        
    }
}
