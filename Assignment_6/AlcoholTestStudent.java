import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Unit tests for the Alcohol class
public class AlcoholTestStudent {

    private Alcohol alcohol;

    @Before
    public void setUp() {
        alcohol = new Alcohol("Whiskey", Size.LARGE, true);
    }

    @After
    public void tearDown() {
        alcohol = null;
    }

    @Test
    public void testConstructorAndAttributes() {
        System.out.println("TESTING: Alcohol Constructor and Attributes");

        assertEquals("Whiskey", alcohol.getBevName());
        assertEquals(Size.LARGE, alcohol.getSize());
        assertTrue(alcohol.isWeekend());

        System.out.println("Alcohol attributes are correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testCalcPrice() {
        System.out.println("TESTING: Alcohol calcPrice");

        double expectedPrice = alcohol.calcPrice();
        System.out.println("Expected price for Alcohol: " + expectedPrice);
        assertTrue(expectedPrice == 3.6);

        System.out.println("Price calculation is correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testEquality() {
        System.out.println("TESTING: Alcohol Equality");

        Alcohol sameAlcohol = new Alcohol("Whiskey", Size.LARGE, true);
        assertTrue(alcohol.equals(sameAlcohol));

        Alcohol differentAlcohol = new Alcohol("Vodka", Size.SMALL, false);
        assertFalse(alcohol.equals(differentAlcohol));

        System.out.println("Equality checks passed.");
        System.out.println("----------------------------");
    }
}

// Unit tests for the Coffee class
