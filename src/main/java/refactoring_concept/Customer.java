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
		double totalAmount = 0;
		int frequenRenterPoints = 0;
		
		StringBuilder result = new StringBuilder(getName() + " 고객님의 대여 기록\n");
		
//		비디오 종류별 대여료 계산
		for(Rental each : rentals) {
			
//			적립 포인트를 2 또는 1포인트 증가에 대한 메서드  Rental 클래스에 생성
			frequenRenterPoints+= each.getFrequenRenterPoints();
			
//			이번에 대여하는 비디오 정보와 대여료 출력
			result.append("\t"+each.getMovie().getTitle());
			result.append("\t"+String.valueOf(each.getCharge())+"\n");
			
//			현재까지 누적된 총 대여료에 대한 메서드를 Rental 클래스에 생성
			totalAmount += each.getCharge();
		}//end of for-loop
		result.append("누적 대여료 : "+String.valueOf(totalAmount)+"\n");
		result.append("적립 포인트 : "+String.valueOf(frequenRenterPoints));
		
		return result.toString();
	}//end of method statement
}
