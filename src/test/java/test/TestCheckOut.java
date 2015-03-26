package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import mergeandprocesorsystem.FakeMergeAndProcess;
import mergeandprocesorsystem.IMergeAndProcess;
import cartsystem.*;

import org.junit.Before;
import org.junit.Test;


public class TestCheckOut {
	public ExpirationDate eDate;

	
	@Before
	public void setUp()
	{
		eDate = new ExpirationDate(3, 2020);
	}
	
	@Test
	public void testCheckOutShouldNoBeAllowedOnEmptyCart()
	{
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		Cart cart = new Cart(catalog);
		CreditCard card = new CreditCard("1111111111111111","Oscar Amelunge",eDate);
		List<Object> sell = new ArrayList<Object>();
		Cashier cashier = new Cashier(cart,card,sell,null);
		
	    try {
	    	cashier.checkOut();
	    	fail();
			
		} catch (Exception e) {
			assertEquals("checkout on empty cart is not allowed",e.getMessage());
			assertEquals(sell.isEmpty(),cashier.getSells().isEmpty());
		}
	}
	@Test
	public void testCheckOutProductsFromCartShouldReturnTotalPurchase()
	{
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		Object book = "ISBN00129";
		catalog.put(book, 4.50);
		
		Cart cart = new Cart(catalog);
		cart.add(book, 5);
		
		CreditCard card = new CreditCard("1111111111111111","Oscar Amelunge",eDate);
		List<Object> sell = new ArrayList<Object>();
		
		List<Object> stolenCards = new ArrayList<Object>();
		Double maxAmount = 1900.80;
		IMergeAndProcess process = new FakeMergeAndProcess(maxAmount,stolenCards);
		
		Cashier cashier = new Cashier(cart,card,sell,process);	
		assertTrue(cashier.checkOut());
		assertEquals(22.5,cashier.get_total(),0.01);
		assertEquals(5,cashier.getSells().size());
		
	}
	
	
	
	
}