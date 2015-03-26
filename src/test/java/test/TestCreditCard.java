package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cartsystem.CreditCard;
import cartsystem.ExpirationDate;


public class TestCreditCard {

	private ExpirationDate eDate;


	@Before
	public void setUp()
	{
		eDate = new ExpirationDate(3, 2020);
	}
	
	@Test
	public void testCreditCardNumberShouldNotBeEmpty() {
		try {
			CreditCard card = new CreditCard("", "", eDate);
			fail();
		} catch (Exception e) {
			assertEquals("cc number could not be empty",e.getMessage());
		}
		
	}
	
	@Test
	public void testCreditCardNumberShouldNotLessThan16Digits() {
		try {
			CreditCard card = new CreditCard("111111111111111", "", eDate);
			fail();
		} catch (Exception e) {
			assertEquals("cc should be 16 digits",e.getMessage());
		}
		
	}
	
	@Test
	public void testCreditCardNumberShouldNotGratherThan16Digits() {
		try {
			CreditCard card = new CreditCard("11111111111111111111", "", eDate);
			fail();
		} catch (Exception e) {
			assertEquals("cc should be 16 digits",e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreditCardDigitShouldBeOnlyNumbers() {
		try {
			CreditCard card = new CreditCard("111111a111111111", "", eDate);
			fail();
		} catch (Exception e) {
			assertEquals("cc should be only numbers",e.getMessage());
		}
	}
		
		@Test
		public void testCreditCardIsValid() {
			
			CreditCard card = new CreditCard("1111111111111111", "Oscar Amelunge", eDate);
			assertEquals("1111111111111111",card.getNumber());
			assertEquals("Oscar Amelunge",card.getHolder());
			assertEquals(eDate,card.getExpirationDate());
		}

}
