package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cartsystem.Cart;


public class TestShopingCart {
	
	
	
	@Test
	public void testShoppingCartShouldBeEmptyOnCreate() {
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		Cart cart = new Cart(catalog);
		assertTrue(cart.isEmpty());
	}
	
	@Test
	public void testShoppingCartShouldAddItemsToCart(){
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		Object book = "ISBN00129";
		catalog.put(book,4.50);
		Cart cart = new Cart(catalog);;
		
		cart.add(book,1);
		assertFalse(cart.isEmpty());
		
	}
	
	@Test
	public void testShoppingCartShouldAddOnlyProductsOnCatalog(){
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		Cart cart = new Cart(catalog);
		Object book = "ISBN00129";
		
		try {
			cart.add(book,1);
			fail();
		} catch (Exception e) {
			assertEquals("this item is not in the cagalog",e.getMessage());
			assertTrue(cart.isEmpty());
		}
	}
	
	@Test
	public void testShoppingCartShouldFailOnAddLessThanOneItem(){
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		Object book = "ISBN00129";
		catalog.put(book,4.50);
		Cart cart = new Cart(catalog);
		
		try {
			cart.add(book,0);
			fail();
		} catch (Exception e) {
			assertEquals("items should be greather than 0",e.getMessage());
		}
		
	}
	
	
	

}
