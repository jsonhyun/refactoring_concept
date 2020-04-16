package refactoring_concept;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public String getName() {
		return name;
	}
	
	public String statement() {
		
		StringBuilder result = new StringBuilder(getName() + " 고객님의 대여 기록\n");
		
//		비디오 종류별 대여료 계산
		for(Rental each : rentals) {			
//			이번에 대여하는 비디오 정보와 대여료 출력
			result.append("\t"+each.getMovie().getTitle());
			result.append("\t"+String.valueOf(each.getCharge())+"\n");
			
		}//end of for-loop
		result.append("누적 대여료 : "+String.valueOf(getTotalCharge())+"\n");
		result.append("적립 포인트 : "+String.valueOf(getTotalFrequenRenterPoints()));
		
		return result.toString();
	}//end of method statement
	
	public String htmlStatement() {		
		StringBuilder result = new StringBuilder("<p><h1><em>"+getName() + " 고객님의 대여 기록</em></h1></p>\n");
		
//		비디오 종류별 대여료 계산
		for(Rental each : rentals) {			
//			이번에 대여하는 비디오 정보와 대여료 출력
			result.append(each.getMovie().getTitle()+": ");
			result.append(String.valueOf(each.getCharge())+"<br>\n");
			
		}//end of for-loop
		result.append("<p>누적 대여료 : <em>"+String.valueOf(getTotalCharge())+"</em></p>\n");
		result.append("<p>적립 포인트 : <em>"+String.valueOf(getTotalFrequenRenterPoints()+"</em></p>"));
		
		return result.toString();
	}//end of method statement

	private int getTotalFrequenRenterPoints() {
		int result = 0;
		for(Rental rental : rentals) {
			result += rental.getFrequenRenterPoints();
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}
}
