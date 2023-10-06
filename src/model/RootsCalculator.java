package src.model;

public class RootsCalculator implements EssentialCalculations {
    private double storage = 0;
    private double root_1 = 0;
	private double root_2 = 0;
	private int num_RealRoots = 0;
	private double [] roots_info = new double[3];

    /********************************************************************************
	Name:     rootsPoly
	Purpose:  To calculate the root or roots of a polynomial if there are any
	Details:  Calculates the root(s) of a polynomial if there are any using
	          nested if statements to determine the differential value.
	          There are also two different sets of polynomial arrays, one is for
	          if the user inputed a quadratic polynomial and one is for if the user
	          inputed a linear polynomial.
	Input Parameters:
	          int[] polynomial ,
	Returns:  Nothing.
	********************************************************************************/
    @Override
    public double[] rootsPoly(int[] polynomial) {
		int max_index = -1;
		double a_quad = polynomial[2];
		double b_quad = polynomial[1];
		double c_quad = polynomial[0];
		double a_linear = polynomial[1];
		double b_linear = polynomial[0];
		
		double d = 0;
		
	    d = (Math.pow(b_quad,2) - (4 * a_quad * c_quad));

	    for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
	        if (max_index < index && polynomial[index] != 0) {
	            max_index = index;
	        }
	    }
	    
	    if (max_index == 1) {
	        root_1 = (b_linear * -1) / a_linear;
	        num_RealRoots = 1;
	    }
	    else if (max_index == 2) {
	        if (d > 0) {
	            root_1 = (((-b_quad) + Math.sqrt(d)) / (2 * a_quad));
	            root_2 = (((-b_quad) - Math.sqrt(d)) / (2 * a_quad));
	            num_RealRoots = 2;
	        }
	        else if (d == 0) {
	            root_1 = ((-b_quad) / (2 * a_quad));
	            num_RealRoots = 1;
	        }
	        else if (d < 0) {
	            num_RealRoots = 0;
	        }
	        else {
	        	num_RealRoots = -1;
	        }
	    }
	    roots_info[0] = num_RealRoots;
	    if (num_RealRoots > 0) {
	    	if (num_RealRoots == 1) {
	    		roots_info[1] = root_1;
	    	}
	    	if (num_RealRoots == 2) {
	    		roots_info[1] = root_1;
	    		roots_info[2] = root_2;
	    	}
	    		
	    }
	    	
	    return roots_info;
	}

    public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}
	
	public double [] getRoots_info() {
		return roots_info;
	}


	public void setRoots_info(double [] roots_info) {
		this.roots_info = roots_info;
	}


	public double getRoot_1() {
		return root_1;
	}


	public void setRoot_1(double root_1) {
		this.root_1 = root_1;
	}


	public double getRoot_2() {
		return root_2;
	}


	public void setRoot_2(double root_2) {
		this.root_2 = root_2;
	}


	public int getNum_RealRoots() {
		return num_RealRoots;
	}


	public void setNum_RealRoots(int num_RealRoots) {
		this.num_RealRoots = num_RealRoots;
	}
}
