package src.model;


public class SumCalculator implements EssentialCalculations {
    @Override
     public void sumPoly(int[] poly1, int[] poly2, int[] polySum) {
		for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
			polySum[index] = poly1[index] + poly2[index]; 
		}
		
		return;
	}
}