/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description: Holiday Bonus ragged array manager

 * Due: 12/3/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */





public class HolidayBonus {







	//	
	//	The retail store with the highest amount sold in the category will receive $5,000. 
	//	The retail store with the lowest amount sold in a category will receive $1,000. 
	//	All other retail stores in district #5 will receive $2,000. 
	//	If a retail store didn’t sale anything in a category, or they have a negative sales amount, 
	//	they are not eligible for a bonus in that category.
	//	If only one retail store sold items in a category, they are 
	//	eligible to receive only the bonus of $5000 for that category
	//	


	private static final double HIGHEST_SALES = 5000;
	private static final double NORMAL_SALES = 2000;
	private static final double LOWEST_SALES = 1000;



	//Calculates the holiday bonus for each store

	public static double[] calculateHolidayBonus(double[][] data) {





		boolean dataExists = false;


		for (int i = 0; i < data.length; i++) {

			if (data[i].length > 0) {
				dataExists = true;
			}


		}

		if (!dataExists) {

			double[] noData = new double[data.length];






			return noData;
		}





		// get total amount of elements in ragged array
		int totalElements = 0;

		// get the row with the most columns
		int maxRowLength = 0;

		// makes an array with same dimensions as data but initialized to normal sales
		double[][] dataClone = new double[data.length][];


		for (int rows = 0; rows < data.length; rows++) {

			dataClone[rows] = new double[data[rows].length];

			for (int cols = 0; cols < data[rows].length; cols++) {


				if (data[rows].length > 0) {
					totalElements++;	

					dataClone[rows][cols] = NORMAL_SALES;
				}

			}


			if(data[rows].length > maxRowLength) {
				maxRowLength = data[rows].length;
			}


		}


		double[] bonus = new double[totalElements];





		for (int col = 0; col < maxRowLength; col++) {

			// double highestInCol = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);


         
			int lowestIndex  = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
			int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);



			// make the data clone with all initialized normal sales have the corresponding highest and lowest bonus
			if (col < dataClone[lowestIndex].length) {
			    dataClone[lowestIndex][col] = LOWEST_SALES;
			}

			
			
			dataClone[highestIndex][col] = HIGHEST_SALES;


			//            if(lowestIndex == highestIndex) {
			//				dataClone
			//			}


			for (int row = 0; row < data.length; row++) {


				// if the column index is less than the length of the current row

				if( col < data[row].length) {


					// if the data double is invalid for bonus

					if (data[row][col] <= 0) {



						dataClone[row][col] = 0;



					}



				}



			}

		}






		// counter for bonus index. bonus was initialized with total elements from data,
		// therefore incrementing simultaneously should be fine
		int bonusCounter = 0;
		for (int rows = 0; rows < dataClone.length; rows++) {

			for (int cols = 0; cols < dataClone[rows].length; cols++) {


				bonus[bonusCounter] = dataClone[rows][cols];

				bonusCounter++;

			}


		}



		// oops i was doing the wrong thing (was making an array of each bonus for the sales)


		// trueBonus holds the bonus total for each store
		double[] trueBonus = new double[dataClone.length];



		for (int rows = 0; rows < dataClone.length; rows++) {

			for (int cols = 0; cols < dataClone[rows].length; cols++) {


				trueBonus[rows] = trueBonus[rows] + dataClone[rows][cols]; 

				
				System.out.println("DataClone Index: " + rows + "," + cols + " value: " + dataClone[rows][cols]);
			}


		}






		// an array of the bonus for each store
		return trueBonus;
	}



	// Calculates the total holiday bonuses

	public static double calculateTotalHolidayBonus(double[][] data)  {

		double[] bonus = HolidayBonus.calculateHolidayBonus(data);

		double total = 0;

		for (int i = 0; i < bonus.length; i++) {

			total+= bonus[i];


		}




		// the total of all holiday bonuses

		return total;
	}










}
