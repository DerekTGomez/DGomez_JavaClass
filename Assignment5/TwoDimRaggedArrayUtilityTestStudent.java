/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: ragged array junit tests

 * Due: 12/3/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */


import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityTestStudent {

    // Utility method to create a temporary file for testing readFile()
    private File createTempFile(String content) throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(content);
        }
        return tempFile;
    }

    // Test for readFile()
    @Test
    public void testReadFile() throws Exception {
        String content = "1.0 2.0 3.0\n4.0 5.0\n6.0";
        File testFile = createTempFile(content);

        double[][] expected = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };

        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);
        assertArrayEquals(expected, result);
    }

    // Test for writeToFile()
    @Test
    public void testWriteToFile() throws Exception {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        File testFile = File.createTempFile("test", ".txt");
        TwoDimRaggedArrayUtility.writeToFile(data, testFile);

        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);
        assertArrayEquals(data, result);
    }

    // Test for getTotal()
    @Test
    public void testGetTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(21.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    // Test for getAverage()
    @Test
    public void testGetAverage() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(3.5, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    // Test for getRowTotal()
    @Test
    public void testGetRowTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(data, 0), 0.001);
    }

    // Test for getColumnTotal()
    @Test
    public void testGetColumnTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
    }

    // Test for getHighestInRow()
    @Test
    public void testGetHighestInRow() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 0), 0.001);
    }

    // Test for getHighestInRowIndex()
    @Test
    public void testGetHighestInRowIndex() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
    }

    // Test for getLowestInRow()
    @Test
    public void testGetLowestInRow() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.001);
    }

    // Test for getLowestInRowIndex()
    @Test
    public void testGetLowestInRowIndex() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
    }

    // Test for getHighestInArray()
    @Test
    public void testGetHighestInArray() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
    }

    // Test for getLowestInArray()
    @Test
    public void testGetLowestInArray() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }
}
