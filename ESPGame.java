/*

 * Class: CMSC203 CRN:21525

 * Instructor: Khandan Monshi

 * Description: An ESP game that reads from a file then accepts user inputs as guesses 

 * Due: 09/17/2024

 * Platform/compiler: Eclipse Java

 * I pledge that I have completed the programming assignment

* independently. I have not copied the code from a student or  
* any source. I have not given my code to any student.

 * Print your Name here: Derek Gomez

*/






import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {

    public static void main (String[] args) throws FileNotFoundException {

        // Define constant color values
        final String COLOR_BLACK = "Black", COLOR_WHITE = "White", COLOR_GRAY = "Gray",
                     COLOR_SILVER = "Silver", COLOR_MAROON = "Maroon", COLOR_RED = "Red",
                     COLOR_PURPLE = "Purple", COLOR_FUCHSIA = "Fuchsia",
                     COLOR_GREEN = "Green", COLOR_LIME = "Lime", COLOR_OLIVE = "Olive",
                     COLOR_YELLOW = "Yellow", COLOR_NAVY = "Navy", COLOR_BLUE = "Blue",
                     COLOR_TEAL = "Teal", COLOR_AQUA = "Aqua";

        // enter the name of the file which shoould be colors.txt
        System.out.println("CMSC203 Assignment1: Test your ESP skills!\nEnter the filename: ");

        // user input
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        // Open the file based on user input, should always be colors.txt
        File file = new File(userInput);
        Scanner fileScanner = new Scanner(file);

        // print each line until there are no more
        while(fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        System.out.println();

        //  round and correct guesses counters
        int round = 1, correct = 0;
        // number of rounds to play
        final int MAX_ROUNDS = 3;  

        Random rand = new Random();

        // loop for the game
        do {
            
        	System.out.println();
            System.out.println("Round " + round + "\n");
            System.out.println("I am thinking of a color.");
            System.out.println("Is it one of the colors above?");
            System.out.println("Enter your guess: ");

            //  random color between 1 and 16
            int randomColor = rand.nextInt(16) + 1;
            String guess = input.nextLine();

            // variable for computer's color choice
            String compChoice = "null";

            // sets the random number to its coressponding color and then adds to the score if it matches user
            switch(randomColor) {
                case 1:
                    compChoice = COLOR_BLACK;
                    if(guess.equalsIgnoreCase(COLOR_BLACK)) correct++;
                    break;
                case 2:
                    compChoice = COLOR_WHITE;
                    if(guess.equalsIgnoreCase(COLOR_WHITE)) correct++;
                    break;
                case 3:
                    compChoice = COLOR_GRAY;
                    if(guess.equalsIgnoreCase(COLOR_GRAY)) correct++;
                    break;
                case 4:
                    compChoice = COLOR_SILVER;
                    if(guess.equalsIgnoreCase(COLOR_SILVER)) correct++;
                    break;
                case 5:
                    compChoice = COLOR_MAROON;
                    if(guess.equalsIgnoreCase(COLOR_MAROON)) correct++;
                    break;
                case 6:
                    compChoice = COLOR_RED;
                    if(guess.equalsIgnoreCase(COLOR_RED)) correct++;
                    break;
                case 7:
                    compChoice = COLOR_PURPLE;
                    if(guess.equalsIgnoreCase(COLOR_PURPLE)) correct++;
                    break;
                case 8:
                    compChoice = COLOR_FUCHSIA;
                    if(guess.equalsIgnoreCase(COLOR_FUCHSIA)) correct++;
                    break;
                case 9:
                    compChoice = COLOR_GREEN;
                    if(guess.equalsIgnoreCase(COLOR_GREEN)) correct++;
                    break;
                case 10:
                    compChoice = COLOR_LIME;
                    if(guess.equalsIgnoreCase(COLOR_LIME)) correct++;
                    break;
                case 11:
                    compChoice = COLOR_OLIVE;
                    if(guess.equalsIgnoreCase(COLOR_OLIVE)) correct++;
                    break;
                case 12:
                    compChoice = COLOR_YELLOW;
                    if(guess.equalsIgnoreCase(COLOR_YELLOW)) correct++;
                    break;
                case 13:
                    compChoice = COLOR_NAVY;
                    if(guess.equalsIgnoreCase(COLOR_NAVY)) correct++;
                    break;
                case 14:
                    compChoice = COLOR_BLUE;
                    if(guess.equalsIgnoreCase(COLOR_BLUE)) correct++;
                    break;
                case 15:
                    compChoice = COLOR_TEAL;
                    if(guess.equalsIgnoreCase(COLOR_TEAL)) correct++;
                    break;
                case 16:
                    compChoice = COLOR_AQUA;
                    if(guess.equalsIgnoreCase(COLOR_AQUA)) correct++;
                    break;
            }

            // output the color the computer was thinking of
            System.out.println("\nI was thinking of: " + compChoice);

            round++; 
        } 
        while(round <= MAX_ROUNDS);

        // how many right vs total rounds
        System.out.println("\nGAME OVER\n");
        System.out.println("You guessed " + correct + " out of " + MAX_ROUNDS + " colors correctly.");

        // inputs for personal information
        System.out.print("Enter your name: ");
        String userName = input.nextLine();

        System.out.print("Describe yourself: ");
        String userDesc = input.nextLine();

        System.out.print("Due Date: ");
        String dueDate = input.nextLine();

        // display the information
        System.out.println("\nUser Name: " + userName);
        System.out.println("User Description: " + userDesc);
        System.out.println("Date: " + dueDate);

        // close scanners
        input.close();
        fileScanner.close();
    }
}
