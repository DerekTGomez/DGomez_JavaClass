import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	
	private GradeBook GB1;
	private GradeBook GB2;
	
	// for testFinalScore
	private GradeBook emptyGradeBook;
	
	@BeforeEach
	void setUp() throws Exception {
	
		GB1 = new GradeBook(5);
		GB2 = new GradeBook(5);
		emptyGradeBook = new GradeBook(0);
		
		
		GB1.addScore(1);
		GB1.addScore(2);
		GB1.addScore(3);
		GB1.addScore(4);
		GB1.addScore(5);
	// {1.0 , 2.0 , 3.0 , 4.0 , 5.0}	
		
	    GB2.addScore(68);
	    GB2.addScore(70);
	    GB2.addScore(10);
	// {68.0, 70.0, 10.0, 0.0, 0.0}
	}

	@AfterEach
	void tearDown() throws Exception {
		
		GB1 = GB2 = emptyGradeBook = null;
		
	}


	@Test
	void testAddScore() {
		/*
		 * use the toString method to compare the contents of what is
		 *  in the scores array vs. what is expected to be in the scores array AssertTrue(..)
		 */
		
		// essentially the toString test
		
		String expectedGB1 = "1.0 2.0 3.0 4.0 5.0 ";
		String expectedGB2 = "68.0 70.0 10.0 0.0 0.0 ";
		
		//using assertTrue
		assertTrue(expectedGB1.equals(GB1.toString()));
		assertTrue(expectedGB2.equals(GB2.toString()));
		
		// it says assertTrue but assertEquals is better here i think:
		assertEquals(expectedGB1, GB1.toString()); 
		assertEquals(expectedGB2, GB2.toString()); 
		
		/*
		 * Compare the scoreSize to the expected number of scores entered, using assertEquals(. . .)
		 */
		
		//this also simultaneously tests getScoreSize	
		assertEquals(5, GB1.getScoreSize());
		assertEquals(3, GB2.getScoreSize());
		assertTrue(0 == emptyGradeBook.getScoreSize());
	}

	@Test
	void testSum() {
		/*
		 * Compare what is returned by sum() to the expected sum of the scores entered.
		 */
		
		//expected sum 1 = 1 + 2 + 3 + 4 + 5 = 15
		//expected sum 2 =  68 + 70 + 10 = 148
		assertTrue(15.0 == GB1.sum());
		assertTrue(148.0 == GB2.sum());
		assertTrue(0 == emptyGradeBook.sum());
	}

	@Test
	void testMinimum() {
		/*
		 * Compare what is returned by minimum() to the expected minimum of the scores entered.
		 */
		// min of GB1 == 1
		//min of GB2 == 10
		
		assertTrue(1 == GB1.minimum());
		assertTrue(10 == GB2.minimum());
		assertTrue(0 == emptyGradeBook.minimum());
	}

	@Test
	void testFinalScore() {
		
		//variable version
		assertTrue((GB1.sum() - GB1.minimum()) == GB1.finalScore());
		assertTrue((GB2.sum() - GB2.minimum()) == GB2.finalScore());
		
		//hard version : 15 - 1 == 14 ; 148 - 10 == 138
		assertTrue(14.0 == GB1.finalScore());
		assertTrue(138.0 == GB2.finalScore());
		
		// no scores check, went back and created empty gradebook 
		
		assertTrue(0 == emptyGradeBook.finalScore());
		
	}

}
