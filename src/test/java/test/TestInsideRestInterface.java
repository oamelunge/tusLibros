package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import cartsystem.InsideRest;

public class TestInsideRestInterface {

	private InsideRest _inside;

	@Test
	public void testCreateCartShouldReturnCartId()
	{
		String id = cartInitializer();
		assertTrue(_inside.listCartItems(id).isEmpty());
	}

	
	@Test
	public void testCreateCartShouldReturnCartErrorIfInvalidUserNameOrPassword()
	{
		InsideRest inside = new InsideRest();
		try {
			inside.createCart("oamelunge1","Lagarto33");
			fail();
		} catch (Exception e) {
			assertEquals("Invalid UserName or Password",e.getMessage());
		}
	}
	@Test
	public void testAddItemsToCartShouldReturnCartItems()
	{

		String id = cartInitializer();
		Object libro1="12345";
		Object libro2="123456";
		_inside.addItem(libro1,3, id);
		_inside.addItem(libro2,3, id);
		
		assertEquals(6,_inside.listCartItems(id).size());
	}
	
	@Test
	public void testCartWithItemsShouldBeValindOnlyFor30Minutes()
	{
		
		InsideRest inside = new InsideRest(LocalDateTime.now().minusMinutes(31));
		String id = inside.createCart("oamelunge","Lagarto33");
		Object libro1="12345";
		Object libro2="123456";
		inside.addItem(libro1,3, id);
		inside.addItem(libro2,3, id);
		
		try {
			inside.checkOut(id);
			fail();
		} catch (Exception e) {
			assertEquals("time for purchase has expire",e.getMessage());

		}
		
		
	}
	
	private String cartInitializer() {
		_inside = new InsideRest();
		return _inside.createCart("oamelunge","Lagarto33");
	}
	
	
}
