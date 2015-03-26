package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import cartsystem.InsideRest;

public class TestInsideRestInterface {

	@Test
	public void testCreateCartShouldReturnCartId()
	{
		InsideRest inside = new InsideRest();
		String id = inside.createCart("oamelunge","Lagarto33");
		assertTrue(inside.listCartItems(id).isEmpty());
	}
	
	@Test
	public void testAddItemsToCartShouldReturnCartItems()
	{
		InsideRest inside = new InsideRest();
		String id = inside.createCart("oamelunge","Lagarto33");
		Object libro1="12345";
		Object libro2="123456";
		inside.addItem(libro1,3);
		inside.addItem(libro2,3);
		
		assertEquals(6,inside.listCartItems(id).size());
	}
	
	@Test
	public void testCartWithItemsShouldBeValindOnlyFor30Minutes()
	{
		
		InsideRest inside = new InsideRest(LocalDateTime.now().minusMinutes(31));
		String id = inside.createCart("oamelunge","Lagarto33");
		Object libro1="12345";
		Object libro2="123456";
		inside.addItem(libro1,3);
		inside.addItem(libro2,3);
		
		try {
			inside.checkOut(id);
			fail();
		} catch (Exception e) {
			assertEquals("time for purchase has expire",e.getMessage());
//			assertEquals(0,inside.get_listOfActiveCart()
//									.stream().filter(c -> c.get_idActiveCart()==id)
//										.findFirst().get());
		}
		
		
	}
	
	
}
