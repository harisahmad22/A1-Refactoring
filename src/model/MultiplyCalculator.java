package src.model;

/********************************************************************************
	Name:     multiplyPolys
	Purpose:  To multiply two polynomials together and provide their product
	Details:  The function has two indexes and they both increment upwards by 1 from
	          0 to 20. As long as the added values of the two indexes are less than
	          or equal to 20, the product at the sum of those two added indexes is
	          calculated. If the combined indexes are greater than 20 then the
	          product is not calculated.
	Input Parameters:
	          int[] poly1,
	                poly2,
	                product
	
	Returns:  Nothing.
	********************************************************************************/
public class MultiplyCalculator implements EssentialCalculations {
    
    @Override
    public boolean multiplyPolys(int[] poly1, int[] poly2, int[] product) {
        boolean productFound = true;
		
		BasicCalculations newCalculation = new BasicCalculations();
		newCalculation.clearPoly(product);
				
		for (int index2 = 0; index2 < BasicCalculations.MAX_SIZE && productFound == true; index2++) {
	        if (poly2 [index2] != 0) {
	            
	        	for (int index1 = 0; index1 < BasicCalculations.MAX_SIZE && productFound == true; index1++) {
	                if (poly1 [index1] != 0) {
	                    if ((index1 + index2) >= 21 || (index1 + index2) <= -1) {	
	                        productFound = false;
	                    }
	                    else {
	                        productFound = true;
	                        product [index1 + index2] += (poly1[index1] * poly2[index2]);
	                    }
	                }
	            }
	        }
	    }
		
	    return productFound;
    }
}
