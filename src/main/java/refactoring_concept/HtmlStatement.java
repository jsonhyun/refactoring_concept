package refactoring_concept;

public class HtmlStatement extends Statement{

	@Override
	String footerString(Customer aCustomer) {
		return String.format("<p>누적 대여료 : <em>%s</em></p>%n<p>적립 포인트 : <em>%s</em></p>", aCustomer.getTotalCharge(), aCustomer.getTotalFrequenRenterPoints());
	}

	@Override
	String eachRentalString(Rental aRental) {
		return String.format("%s : %s<br>%n", aRental.getMovie().getTitle(), aRental.getCharge());
	}

	@Override
	String headerString(Customer aCustomer) {
		return String.format("<p><h1><em>%s 고객님의 대여 기록 </em></h1></p>%n", aCustomer.getName());
	}

}
