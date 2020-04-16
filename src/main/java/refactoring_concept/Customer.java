package refactoring_concept;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Rental> getRentals(){
		return this.rentals;
	}
	
	public String statement() {
		return new TextStatement().value(this);
	}//end of method statement
	
	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}//end of method statement

	public int getTotalFrequenRenterPoints() {
		int result = 0;
		for(Rental rental : rentals) {
			result += rental.getFrequenRenterPoints();
		}
		return result;
	}

	public double getTotalCharge() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}
	

}
