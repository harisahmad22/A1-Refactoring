package src.model;
/**
 * 
 * @author Haris Ahmad
 */
import java.util.Scanner;

public class BasicCalculations {
	public static final int MAX_SIZE = 21;
	
	/********************************************************************************
	Name:     readPoly
	Purpose:  To generate the input for the user in the form of "coefficient"
	          followed by the "exponent" until the the user enters "0 0" which 
	          at that point stops user input.
	Details:  Calls upon the clearPoly function to clear any previous arrays and
	          then uses a while loop so that as long as the polynomial is still
	          in correspondence with the guidelines (exponent between -1 and 21)
	          and the file has not reached the end, the read will continue.
	Input Parameters:
	          int polynomial []
	Returns:  Nothing.
	********************************************************************************/
	public boolean readPoly(int[] polynomial) {
		int coefficient = 0;
		boolean repeat = false;
		boolean success = true;
		int index = 0;

		clearPoly(polynomial); 
		System.out.println(); 
		System.out.println("Enter a coefficient and an exponent with only one corresponding base for every exponent.");
		System.out.println("Format: coefficient exponent, with whitespace in middle. Enter 0 0 to indicate end of polynomial: ");
		
		Scanner kb = new Scanner(System.in);

		while (kb.hasNextLine() && success == true) {
			coefficient = Integer.parseInt(kb.next());
			index = Integer.parseInt(kb.next());
			
			if (polynomial [index] != 0 || index >= 21 || index < 0 || (coefficient == 0 && index == 0)){
				success = false;
				kb.close();
				return success; 
			}
			else {
					success = true;
					repeat = true;
					polynomial[index] = coefficient;
			}
		}
		if (!repeat || !success){
			success = false;
			repeat = true;
			kb.close();
			return success;
		}
		else{
			kb.close();
			success = true;
		}

		return success;
	}
	


	/********************************************************************************
	Name:     printPoly
	Purpose:  To print out the polynomial that the user entered in an exponential
	          form (if necessary) using 'x' as the value for the unknown.
	Details:  Uses a series of loops and decision statements to narrow down possible
	          situations for the output. These take in whether or not the base is
	          negative, the value of the exponent, and the value of the base.
	          Based on that, it will display the polynomial to the user in the proper
	          format, showing both positive and negative symbols when appropriate
	          based on the input.
	Input Parameters:
	          int polynomial []
	Returns:  Nothing.
	********************************************************************************/
	public void printPoly (int[] polynomial) {
		int max_exponent = -1;
		boolean isFirstTerm = true;

		for (int index = MAX_SIZE - 1; index >= 0; index--) {
			int coefficient = polynomial[index];

			if (coefficient != 0) {
				if (!isFirstTerm) {
					if (coefficient > 0) {
						System.out.print(" + ");
					} else {
						System.out.print(" - ");
						coefficient *= -1;
					}
				} else {
					isFirstTerm = false;
				}

				if (coefficient != 1 || index == 0) {
					System.out.print(coefficient);
				}

				if (index > 1) {
					System.out.print("x^" + index);
				} else if (index == 1) {
					System.out.print("x");
				}

				max_exponent = index;
			}
		}

		if (max_exponent == -1) {
			System.out.print("0");
		}

		System.out.println();

		return;
	}


	/********************************************************************************
	Name:     clearPoly
	Purpose:  To clear the previous polynomial values if their are any and set the
	          array to 0.
	Details:  The exponent starts off at 0 and increases until it reaches the
	          permitted exponent value and so the exponent goes through all the
	          numbers between 0 and 20. For each of these values between the numbers
	          the array is set to 0, so overall the array is reset.
	Input Parameters:
	          int polynomial []
	Returns:  Nothing.
	********************************************************************************/
	public void clearPoly (int [] polynomial) {
	    for (int index = 0; index < MAX_SIZE; index ++) { 
	        polynomial [index] = 0;
	    }

	    return;
	}
}
