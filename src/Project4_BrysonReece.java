// Yay, imports!
import java.util.Random;
import java.util.Scanner;

/*
 * @title: Word Scrambler
 * @author: Bryson Reece
 * 
 * @description: This program rearranges the letters of given
 * inputs. Useful for games like Scrabble(TM).
 */

public class Project4_BrysonReece {
	// Let's get started!
	public static void main(String[] args) {
		// Prints out our welcome message.
		System.out.println("Welcome to the Word Scrambler");
		// We call the getInput method to randomize and display our input/output.
		getInput(args);
	}
	// This method prompts the user for input and returns the shuffled value of that input.
	public static void getInput(String[] args) {
		// Here we set up an empty string to hold our input once it's converted to a String.
		String inputWords = "";
		// We run checks to see if our user provided any input
		if (args == null) {
			inputWords = "";
		}
		else {
			// We cycle through our input, appending each word to our string placeholder above.
			for (int i = 0; i < args.length; i++) {
				// If we reach the end, come to a full stop,
				if (i == args.length) {
					inputWords = inputWords + args[i];
				}
				// Otherwise print out our current word plus a space.
				else {
					inputWords = inputWords + args[i] + " ";
				}
			}
		}
		// Now we display what our user provided as input.
		System.out.print("Input Words: " + inputWords);
		// We input a newline character.
		System.out.println("");
		// Then print out our Output heading.
		System.out.print("Output Words: ");
		// Now we loop through our input array, calling the shuffle method on the current value, and then printing the results.
		for (int i = 0; i < args.length; i++) {
			// You see we have a special method "scramble" to shuffle our characters.
			args[i] = scramble(args[i]);
			// And then append our scrambled word to our output for the user to see.
			System.out.print(args[i] + " ");
		}
		// Then print a newline character.
		System.out.println("");
		// Now we prompt our user to continue or exit.
		System.out.println("Enter 1 to search again, 0 to exit the program");
		// Then listen for our user input as an integer.
		Scanner scanner = new Scanner(System.in);
		int userOption = scanner.nextInt();
		// If the user selected 0, exit the program.
		if (userOption == 0) {
			// Close our scanner
			scanner.close();
			// ...and the user is out of the building.
			System.exit(0);
		}
		// If the user selected 1, shuffle their input again.
		else if (userOption == 1) {
			getInput(args);
		}
	}
	// Our method to input a string and return a shuffled variation.
	public static String scramble(String inputString )
	{
	    // Converts our string into a char array.
	    char input[] = inputString.toCharArray();
	
	    // Cycles through our char array and swaps values with a corresponding random value. 
	    for (int i = 0; i < input.length - 1; i++) {
	    	// Initializes our built-in Random function.
	        Random random = new Random();
	        // Sets our range for Random and assigns the statement to g.
			int g = random.nextInt(input.length - 1);
			// Set our current array value as a temp since we're going to change it.
	        char tmp = input[i];
	        // Selects a random value in the array and switches its key with our current value.
	        input[i] = input[g];
	        input[g] = tmp;
	    }
	    // Converts our modified input array to a String and assigns it to output.
	    String output = new String(input);
	    // Returns our output value
	    return output;
	}
}
