package refactoring_concept;

public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private String title;
	private Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int aPriceCode) {
		switch (aPriceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;

		default:throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
		}
	}

	public String getTitle() {
		return title;
	}
	
	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}
	
	public int getFrequenRenterPoints(int daysRented) {
		return price.getFrequenRenterPoints(daysRented);
	}

}
