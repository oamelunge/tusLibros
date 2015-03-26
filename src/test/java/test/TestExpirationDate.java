package test;
import static org.junit.Assert.*;

import org.junit.Test;

import cartsystem.ExpirationDate;


public class TestExpirationDate {

	@Test
	public void testExpirationDateMonthShouldBeGratherThanZero() {
		
		try {
			ExpirationDate edate = new ExpirationDate(0,0);
			fail();
		} catch (Exception e) {
			assertEquals("expiration month should be between 1 and 12", e.getMessage());
		}
	}
	
	@Test
	public void testExpirationDateMonthGratherOrEqualThanCurrentYearMonth() {
		
		try {
			ExpirationDate edate = new ExpirationDate(1,0);
			fail();
		} catch (Exception e) {
			assertEquals("month should be equal or grather than current one", e.getMessage());
		}
	}

	@Test
	public void testExpirationDateYearShouldBeGratherOrEqualThanCurrentYear() {
		
		try {
			ExpirationDate edate = new ExpirationDate(12,0);
			fail();
		} catch (Exception e) {
			assertEquals("year should be grather or equal than current year", e.getMessage());
		}
		
	}
	@Test
	public void testExpirationDateYearShouldNoBe20YearsGratherThanCurrentYear() {
		
		try {
			ExpirationDate edate = new ExpirationDate(12,2500);
			fail();
		} catch (Exception e) {
			assertEquals("year to big", e.getMessage());
		}
		
	}
	
	@Test
	public void testExpirationDateMonthIsValidMonth()
	{
		ExpirationDate edate = new ExpirationDate(12,2015);
		assertEquals(12,edate.getMonth());
	}

	@Test
	public void testExpirationDateYearIsValidYear()
	{
		ExpirationDate edate = new ExpirationDate(12,2015);
		assertEquals(2015,edate.getYear());
	}
}
