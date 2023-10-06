package src.model;

public class DifferentiateCalculator implements EssentialCalculations {

	private int new_exponent;
	private int bring_down;

    @Override
    public void differentiate(int[] polynomial, int[] diff_poly) {
		
		for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
			setBring_down((polynomial[index] * index));
			
			if (index > 0) {
			setNew_exponent((index - 1));
			diff_poly[getNew_exponent()] = getBring_down();
			}
		}
		return;
	}

    public int getNew_exponent() {
		return new_exponent;
	}


	public void setNew_exponent(int new_exponent) {
		this.new_exponent = new_exponent;
	}


	public int getBring_down() {
		return bring_down;
	}


	public void setBring_down(int bring_down) {
		this.bring_down = bring_down;
	}
}
	

