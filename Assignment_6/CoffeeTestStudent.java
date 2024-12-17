import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class CoffeeTestStudent {

    private Coffee coffee;

    @Before
    public void setUp() {
        coffee = new Coffee("Espresso", Size.SMALL, true, false);
    }

    @After
    public void tearDown() {
        coffee = null;
    }

    @Test
    public void testConstructorAndAttributes() {
        System.out.println("TESTING: Coffee Constructor and Attributes");

        assertEquals("Espresso", coffee.getBevName());
        assertEquals(Size.SMALL, coffee.getSize());
        assertTrue(coffee.getExtraShot());
        assertFalse(coffee.getExtraSyrup());

        System.out.println("Coffee attributes are correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testCalcPrice() {
        System.out.println("TESTING: Coffee calcPrice");

        double expectedPrice = coffee.calcPrice();
        System.out.println("Expected price for Coffee: " + expectedPrice);
        assertTrue(expectedPrice == 2.5);

        System.out.println("Price calculation is correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testEquality() {
        System.out.println("TESTING: Coffee Equality");

        Coffee sameCoffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertTrue(coffee.equals(sameCoffee));

        Coffee differentCoffee = new Coffee("Latte", Size.MEDIUM, false, true);
        assertFalse(coffee.equals(differentCoffee));

        System.out.println("Equality checks passed.");
        System.out.println("----------------------------");
    }
}
