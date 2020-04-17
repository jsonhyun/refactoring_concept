package refactoring_concept;

public abstract class Price {
	abstract int getPriceCode();
	
	abstract double getCharge(int daysRented);
	
	public int getFrequenRenterPoints(int daysRented) {
		return 1;
	}
}
