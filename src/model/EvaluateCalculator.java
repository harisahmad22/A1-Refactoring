package src.model;

import java.util.Scanner;

/********************************************************************************
	Name:     evaluate
	Purpose:  To calculate the overall value of the polynomial by substituting a
	          value for the unknown.
	Details:  For every value in the index (all exponent values from 0-20), the array
	          at that specific value multiplies itself by the unknown to the power of
	          the index at that given position.
	Input Parameters:
	          int [] poly
	          int x,
	              poly1Value
	              
	Returns:  Nothing.
	********************************************************************************/
public class EvaluateCalculator implements EssentialCalculations {
	private double storage = 0;

    @Override
    public void evaluate(int[] poly1, int x, int poly1Value) {
		Scanner key_board = new Scanner(System.in);
		
		if (key_board.hasNextLine()) {
			x = Integer.parseInt(key_board.nextLine());
		}
	
		for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
			setStorage(getStorage() + poly1[index] * Math.pow(x, index));
			poly1Value = (int)getStorage();
		}		
		
		System.out.println("The polynomial evaluates to: " + poly1Value);

		key_board.close();
		return;
	}    

    public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}
}

