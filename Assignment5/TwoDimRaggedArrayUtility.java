/*

 * Class: CMSC203 21525

 * Instructor: Khandan Monshi

 * Description:  ragged array methods

 * Due: 12/3/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class TwoDimRaggedArrayUtility {

	
	
	// Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for each row is 10
	// Each row in the file is separated by a new line Each element in the row is separated by a space 
	// Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array. 
	// 1. Read the doubles from the file into a temporary array [MAX_ROW][MAX_COLUMN] of Strings which was initialized to nulls.
	// 2. Find out how many rows there are (any row that has the first element != null is a valid row) 
	// 3. Create the array based on the number of rows, i.e. double[][]array = new double[#rows][] 
	// 4. Determine the number of columns for the first row (any element != null is a valid element) 
	// 5. Create the first row, i.e. array[0] = new double[#columns] 
	// 6. Put the values from the temporary array into in the row (don't forget to convert from strings to doubles) 
	// 7. Repeat for all rows
	
	public static double[][] readFile(File file) throws FileNotFoundException {
        final int MAX_ROWS = 10;
        final int MAX_COLUMNS = 10;

        // Step 1: Create a temporary array to hold Strings
        String[][] tempArray = new String[MAX_ROWS][MAX_COLUMNS];

        Scanner scanner = new Scanner(file);

        int rowCount = 0;

        // Step 2: Read the file into the temporary array
        while (scanner.hasNextLine() && rowCount < MAX_ROWS) {
            String line = scanner.nextLine();
            String[] rowElements = line.split(" ");

            for (int col = 0; col < rowElements.length && col < MAX_COLUMNS; col++) {
                tempArray[rowCount][col] = rowElements[col];
            }

            rowCount++;
        }

        scanner.close();

        // If no rows were read, return null
        if (rowCount == 0) {
            return null;
        }

        // Step 3: Create the ragged array
        double[][] raggedArray = new double[rowCount][];

        // Step 4: Populate the ragged array
        for (int row = 0; row < rowCount; row++) {
            // Determine the number of valid columns in the row
            int colCount = 0;
            for (int col = 0; col < MAX_COLUMNS; col++) {
                if (tempArray[row][col] != null) {
                    colCount++;
                } else {
                    break;
                }
            }

            // Step 5: Create the row
            raggedArray[row] = new double[colCount];

            // Step 6: Convert Strings to doubles and populate the row
            for (int col = 0; col < colCount; col++) {
                raggedArray[row][col] = Double.parseDouble(tempArray[row][col]);
            }
        }

        // a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
        return raggedArray;
    }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    // Writes the ragged array of doubles into the file. 
    // Each row is on a separate line within the file and each double is separated by a space.
    
	
	
	
	public static void writeToFile(double[][] data, File outputFile) throws IOException {
       
//		// Check if the file is valid
//        if (outputFile == null || !outputFile.canWrite()) {
//            
//        	throw new FileNotFoundException("The specified file is invalid or cannot be written to.");
//        
//        }

		FileWriter writer = null;
        try  {
            
        	 writer = new FileWriter(outputFile);
        	
        	for (int i = 0; i < data.length; i++) {
                
        		for (int k = 0; k < data[i].length; k++) {
                    
        			writer.write(data[i][k] + " ");
                
        		}
                
        		writer.write("\n"); // Add a new line for each row
            
        	}
        } catch (IOException e) {
            System.out.println("Error in WriteToFile");
            e.printStackTrace();
            
        }
        writer.close();
        
    }
	
	
	
	
	// Returns the total of all the elements of the two dimensional array
	public static double getTotal(double[][] data) {
		
		
		double total = 0;
		
		for (int i = 0; i < data.length; i++) {
            
    		for (int k = 0; k < data[i].length; k++) {
                
    			total += data[i][k];
            
    		}
		}
		
		
		
		
		
		// Returns the total of all the elements of the two dimensional array

		return total;
	}
	
	
	
	
	//Returns the average of the elements in the two dimensional array

	public static double getAverage(double[][] data) {
		
		double totalELM = 0;
		double numberELM = 0;
		
		
		
             for (int i = 0; i < data.length; i++) {
            
    		for (int k = 0; k < data[i].length; k++) {
                
    			
    			numberELM++;
    			totalELM += data[i][k];
            
    		}
		}
		
		
		
		
		// the average of the elements in the two dimensional array (total of elements/number of elements)
		return (totalELM / numberELM);
	}
	
	
	// Returns the total of the selected row in the two dimensional array index 0 refers to the first row.

	public static double getRowTotal(double[][] data, int row) {
		
		double total = 0;
		
		
		
		for (int i = 0; i < data[row].length; i++) {
			
			total += data[row][i];
			
			
			
		}
		
		
		
		
		// the total of the row
     return total;
		
	}

	
	
	// Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
	// If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.

	public static double getColumnTotal(double[][] data, int col) {
		
		
		
		double total = 0;
		
for (int row = 0; row < data.length; row++) {
			
			
			// if the column index is less than the length of the current row
			if( col < data[row].length) {
				
				total += data[row][col];
				
					
				}
				
				
				
			}
			
  //the total of the column

		return total;
			
		}
		
		
		
	

	
	// Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.

	public static double getHighestInRow(double[][] data, int row) {
		
		
		double max = 0;
		
		
      for (int i = 0; i < data[row].length; i++) {
			
    	  
    	  if (max < data[row][i]) {
			max = data[row][i];
    	  }
			
			
		}
		
		
		
		
		
		
		
		
		// the largest element of the row

		return max;
	}

	
	
	// Returns the index of the largest element of the selected row in the two dimensional array index 0 refers to the first row.

	public static int getHighestInRowIndex(double[][] data, int row) {
		
		
		int index = 0;
		double max = 0;
		
		for (int i = 0; i < data[row].length; i++) {
			
	    	  
	    	  if (max < data[row][i]) {
				max = data[row][i];
				index = i;
	    	  }
				
				
			}
		
		
		
		
		
		// the largest element of the row

		return index;
	}
	
	
	
	// Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.

	public static double getLowestInRow(double[][] data, int row) {
		
		
		double min = data[row][0];
		
		for (int i = 0; i < data[row].length; i++) {
			
	    	  
	    	  if (min > data[row][i]) {
				min = data[row][i];
	    	  }
				
				
			}
		
		
		
		
		
		// the smallest element of the row

		return min;
	}


	//Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.

	public static int getLowestInRowIndex(double[][] data, int row) {
		
      
		
		
		double min = data[0][0];
		int index = 0;
		
		
		
		for (int i = 0; i < data[row].length; i++) {
			
	    	  
	    	  if (min > data[row][i]) {
				min = data[row][i];
	    	  
				index = i;
	    	  }
				
				
			}
		
		
		
		
		// the index of the smallest element of the row

		return index;
	}
	
	// Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column.
	// If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.

	public static double getHighestInColumn(double[][] data, int col) {
		
		double max = Double.MIN_VALUE;
		
		
		
       for (int row = 0; row < data.length; row++) {
			
			
			// if the column index is less than the length of the current row
			if( col < data[row].length) {
				
				
				// if the data double is larger than max
				
				if (data[row][col] > max) {
					
					
					
					max = data[row][col];
					
				}
				
				
				
			}
			
			
			
		}
		
		
		// the largest element of the column

		return max;
	}
	
	// Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column.
	// If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.

	public static int getHighestInColumnIndex(double[][] data, int col) {
	    double max = Double.NEGATIVE_INFINITY; // Use a very small initial value
	    
	    int index = 0; 

	    for (int row = 0; row < data.length; row++) {
	        
	    	
	    	// Check if the current row has the column
	        if (col < data[row].length) {
	            
	        	
	        	
	        	// Update max and index if a larger value is found
	            if (data[row][col] > max) {
	            
	            	max = data[row][col];
	                
	            	index = row;
	            
	            }
	        
	        }
	    
	    }

	    return index;
	}


    // Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	//If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.

	public static double getLowestInColumn(double[][] data, int col) {
		
		double min = data[0][col];
		
for (int row = 0; row < data.length; row++) {
			
			
			// if the column index is less than the length of the current row
			if( col < data[row].length) {
				
				
				// if the data double is smaller than max
				
				if (data[row][col] <= min) {
					
					
					
					min = data[row][col];
					
					
					
				}
				
				
				
			}
			
			
			
		}
		
		
		
		// the smallest element of the column

		return min;
	}
	
	
	// Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	// If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.

	public static int getLowestInColumnIndex(double[][] data, int col) {
	    
		double min = Double.MAX_VALUE; // Use a very large initial value
	    
		int index = 0; 

	    for (int row = 0; row < data.length; row++) {
	      
	    	// Check if the current row has the column
	        
	    	if (col < data[row].length) {
	            // Update min and index if a smaller value is found
	           
	    		if (data[row][col] < min) {
	                min = data[row][col];
	                index = row;
	            
	    		}
	        
	    	}
	    
	    }

	    return index; 
	}

	
	// Returns the largest element in the two dimensional array

	public static double getHighestInArray(double[][] data) {
		
		double max = 0;
		
		
		
		
		for (int rows = 0; rows < data.length; rows++) {
			
			
			for (int cols = 0; cols < data[rows].length; cols++) {
				
				if (data[rows][cols] > max) {
					
					max = data[rows][cols];
					
				}
				
				
				
				
			}
			
			
			
		}
		
		

		return max;
	}
	
	// Returns the smallest element in the two dimensional array

	public static double getLowestInArray(double[][] data) {
		
		
        double min = data[0][0];
				
		
		for (int rows = 0; rows < data.length; rows++) {
			
			
			for (int cols = 0; cols < data[rows].length; cols++) {
				
				if (data[rows][cols] < min) {
					
					min = data[rows][cols];
					
				}
				
				
				
				
			}
			
			
			
		}
		
		
		
		
		// the smallest element in the two dimensional array
		return min;
	}



	
} 
	
