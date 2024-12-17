import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Unit tests for the Customer class
public class CustomerTestStudent {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Alice", 25);
    }

    @After
    public void tearDown() {
        customer = null;
    }

    @Test
    public void testConstructorAndAttributes() {
        System.out.println("TESTING: Customer Constructor and Attributes");

        assertEquals("Alice", customer.getName());
        assertEquals(25, customer.getAge());

        System.out.println("Customer attributes are correct.");
        System.out.println("----------------------------");
    }

    @Test
    public void testSettersAndGetters() {
        System.out.println("TESTING: Customer Setters and Getters");

        customer.setName("Bob");
        assertEquals("Bob", customer.getName());

        customer.setAge(30);
        assertEquals(30, customer.getAge());

        System.out.println("Setters and getters work correctly.");
        System.out.println("----------------------------");
    }

    @Test
    public void testCopyConstructor() {
        System.out.println("TESTING: Customer Copy Constructor");

        Customer copyCustomer = new Customer(customer);
        assertEquals(customer.getName(), copyCustomer.getName());
        assertEquals(customer.getAge(), copyCustomer.getAge());

        
        copyCustomer.setName("JOHNSON");
        
        // Deep copy test
        assertNotEquals(customer.getName(), copyCustomer.getName() );
        
        
        System.out.println("Copy constructor works correctly.");
        System.out.println("----------------------------");
    }

    @Test
    public void testToString() {
        System.out.println("TESTING: Customer toString");

        String expected = "Alice,25";
        assertEquals(expected, customer.toString());

        System.out.println("toString output is correct.");
        System.out.println("----------------------------");
    }
}

// Unit tests for the Smoothie class
