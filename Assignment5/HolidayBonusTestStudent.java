/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Holiday Bonus junuit test

 * Due: 12/3/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */




import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the HolidayBonus class.
 * This includes tests for multiple datasets and edge cases.
 * 
 * @version 12/03/2024
 */
public class HolidayBonusTestStudent {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
    
    // 1    2    3
    // 4    5    
    // 6    7    8
    // store 1: 1000*3= 3000,  store 2: 2000 + 2000= 4000, store 3= 15000
    
    
    
    
    
    
    private double[][] dataSet2 = { { 10, -5, 0 }, { 20 }, { -1, 15, 5 } }; // Edge case: includes negative and zero values
    
    
    //      10   -5   0
    //      20
    //      -1    15  54
    //    store 1: 2000 (-5 and 0 are not counted), store 2: 5000 (highest), store 3: 10000 (not counted then two highest)
    
    
    private double[][] raggedArray = { { 100 }, { 200, 150 }, { 300, 250, 100 } }; // Ragged array
    
    // 100
    // 200    150
    // 300    250   100
    // store 1: 1000, store 2: 2000+ 1000 = 3000, store 3: 15000
    
    
    
    
    
    private double[][] singleStore = { { 50, 60, 70 } }; // Single store category
    
    // 15000
    
    
    
    private double[][] emptyCategory = { {}, {}, {} }; // No values in any category

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateHolidayBonusDataSet1() {
        try {
        	System.out.println("testing");
        	double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
            assertEquals(3000.0, result[0], 0.001);
            assertEquals(4000.0, result[1], 0.001);
            assertEquals(15000.0, result[2], 0.001);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusDataSet1() {
    	System.out.println("testing");
    	assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), 0.001);
    }

    @Test
    public void testCalculateHolidayBonusWithNegativeAndZeroValues() {
        try {
        	System.out.println("testing");
        	double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
            assertEquals(2000.0, result[0], 0.001); // Only valid positive numbers contribute
            assertEquals(5000.0, result[1], 0.001); // Valid single value
            assertEquals(10000.0, result[2], 0.001); // Two valid values in row
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusWithNegativeAndZeroValues() {
    	System.out.println("testing");
    	assertEquals(17000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), 0.001);
    }

    @Test
    public void testCalculateHolidayBonusWithRaggedArray() {
        try {
        	System.out.println("testing");
        	double[] result = HolidayBonus.calculateHolidayBonus(raggedArray);
            assertEquals(1000.0, result[0], 0.001); // Highest bonus for the highest sales in column 1
            assertEquals(3000.0, result[1], 0.001); // Combination of bonuses across multiple valid columns
            assertEquals(15000.0, result[2], 0.001); // Sum of bonuses for all valid columns in row
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusWithRaggedArray() {
    	System.out.println("testing");
    	assertEquals(19000.0, HolidayBonus.calculateTotalHolidayBonus(raggedArray), 0.001);
    }

    @Test
    public void testCalculateHolidayBonusWithSingleStore() {
        try {
        	System.out.println("testing");
        	double[] result = HolidayBonus.calculateHolidayBonus(singleStore);
            assertEquals(15000.0, result[0], 0.001); // Single store gets all bonuses
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusWithSingleStore() {
    	System.out.println("testing");
    	assertEquals(15000.0, HolidayBonus.calculateTotalHolidayBonus(singleStore), 0.001);
    }

    @Test
    public void testCalculateHolidayBonusWithEmptyCategory() {
        try {
        	System.out.println("testing");
        	double[] result = HolidayBonus.calculateHolidayBonus(emptyCategory);
            assertEquals(0.0, result[0], 0.001);
            assertEquals(0.0, result[1], 0.001);
            assertEquals(0.0, result[2], 0.001);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusWithEmptyCategory() {
    	System.out.println("testing");
    	assertEquals(0.0, HolidayBonus.calculateTotalHolidayBonus(emptyCategory), 0.001);
    }
    
    
    
    @Test
    public void testCalculateHolidayBonusWithExpandedDataset() {
        double[][] expandedDataset = {
            { 100, 500, -200, 3000 },   // 2000 2000 0 2000 = 6000
            { 7000, 0, 2500, 1000 },    // 2000 0   5000 2000 = 9000
            { -500, 200, 0, 50 },      // 0 2000 0 1000     =  3000
            { 10000, 3000, 2000, 8000 } // 5000 5000 2000 5000 = 17000
        };
        System.out.println("testing");
        double[] result = HolidayBonus.calculateHolidayBonus(expandedDataset);
        assertEquals(6000, result[0], 0.001);
        assertEquals(9000, result[1], 0.001);
        assertEquals(3000, result[2], 0.001);
        assertEquals(17000, result[3], 0.001);
    }

    @Test
    public void testCalculateHolidayBonusMatchingScreenshot() {
        double[][] screenshotDataset = {
            { 1233.65,  4.50,   7532.45,  3388.44, 0 },
            { 2876.22, -3.24,   1594.66,  0,       0 },
            { 498.22,   2.29,   1549.28,  3794.43, 0 },
            { 2526.76,  3.76,    3526.29, 4265.77, 0 },
            { 5184.38,  0,       3455.76, 6387.23, 4592.45 },
            { 2675.46,  3925.34, 6522.82, 8935.23, 8545.22 }
        };
        System.out.println("testing");
        double[] result = HolidayBonus.calculateHolidayBonus(screenshotDataset);
        assertEquals(11000.0, result[0], 0.001);
        assertEquals(4000.0, result[1], 0.001);
        assertEquals(6000.0, result[2], 0.001);
        assertEquals(8000.0, result[3], 0.001);
        assertEquals(11000.0, result[4], 0.001);
        assertEquals(19000.0, result[5], 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonusMatchingScreenshot() {
        double[][] screenshotDataset = {
            { 1233.65,  4.50,    7532.45, 3388.44, 0 },       // total = 2000 + 2000 + 5000 + 2000 + 0 = 11000
            { 2876.22, -3.24,    1594.66, 0,       0 },       // total = 2000 + 0    + 2000 +    0 + 0 = 4000
            { 498.22,   2.29,    1549.28, 3794.43, 0 },       // total = 1000 + 2000 + 1000 + 2000 + 0 = 6000
            { 2526.76,  3.76,    3526.29, 4265.77, 0 },       // total = 2000 + 2000 + 2000 + 2000 + 0 = 8000
            { 5184.38,  0,       3455.76, 6387.23, 4592.45 }, // total = 5000 + 0    + 2000 + 2000 + 2000 = 11000
            { 2675.46,  3925.34, 6522.82, 8935.23, 8545.22 }  // total = 2000 + 5000 + 2000 + 5000 + 5000 = 19000
        };
        
       int calc =  11000 + 4000 + 6000 + 8000 + 11000 + 19000;
       System.out.println("testing");
        assertEquals(calc, HolidayBonus.calculateTotalHolidayBonus(screenshotDataset), 0.001);
    }

    
    
}
