import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SmoothieTestStudent {

    private Smoothie smoothie;

    @Before
    public void setUp() {
        smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
    }

    @After
    public void tearDown() {
        smoothie = null;
    }

    @Test
    public void testConstructorAndAttributes() {
        System.out.println("TESTING: Smoothie Constructor and Attributes");

        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Size.MEDIUM, smoothie.getSize());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());

        System.out.println("Smoothie attributes are correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testCalcPrice() {
        System.out.println("TESTING: Smoothie calcPrice");

        double expectedPrice = smoothie.calcPrice();
        double exactPrice = 2.0 + 0.5 + (3 * 0.5) + 1.5; // Base price + size price + fruit costs + protein cost
        assertEquals(exactPrice, expectedPrice, 0.0);

        System.out.println("Price calculation is correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testEquality() {
        System.out.println("TESTING: Smoothie Equality");

        Smoothie sameSmoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        assertTrue(smoothie.equals(sameSmoothie));

        Smoothie differentSmoothie = new Smoothie("Tropical Bliss", Size.LARGE, 2, false);
        assertFalse(smoothie.equals(differentSmoothie));

        System.out.println("Equality checks passed.");
        System.out.println("----------------------------");
    }

    @Test
    public void testToString() {
        System.out.println("TESTING: Smoothie toString");

        String expected = "Berry Blast,MEDIUM,3,true," + smoothie.calcPrice();
        assertEquals(expected, smoothie.toString());

        System.out.println("toString output is correct.");
        System.out.println("----------------------------");
    }
}
