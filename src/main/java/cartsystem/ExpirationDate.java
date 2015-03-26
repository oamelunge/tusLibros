package cartsystem;
import java.time.LocalDate;


public class ExpirationDate {

	private int _month;
	private int _year;

	public ExpirationDate(int month, int year) {
		
		checkIfExpirationMonthIsValid(month);
		checkIfExpirationYearIsValid(year);
		this._month = month;
		this._year = year;
	}

	public int getMonth() {
		return this._month;
	}

	public int getYear() {
		return this._year;
	}
	private void checkIfExpirationYearIsValid(int year) {
		if(year<LocalDate.now().getYear())
			throw new RuntimeException("year should be grather or equal than current year");
		if(year>LocalDate.now().getYear()+20)
			throw new RuntimeException("year to big");
	}

	private void checkIfExpirationMonthIsValid(int month) {
		if(month<1 || month>12)
			throw new RuntimeException("expiration month should be between 1 and 12");
		if(month<LocalDate.now().getMonthValue())
			throw new RuntimeException("month should be equal or grather than current one");
	}

}
