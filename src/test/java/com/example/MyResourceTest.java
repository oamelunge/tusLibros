package com.example;

import java.io.Console;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.MyResource;

public class MyResourceTest extends JerseyTest {

    private static final String PASSWORD_PARAMETER = "Lagarto33";
	private static final String PASSWORD_PARAMETER_DESCRIPTION = "password";
	private static final String USER_NAME_PARAMETER = "oamelunge";
    private static final String USER_PARAMETER_DESCRIPTION = "username";
    
    
	private String createCartResource = "myresource/createCart";
	
	private String addToCartResource = "myresource/addToCart";
	

	@Override
    protected Application configure() {
        return new ResourceConfig(MyResource.class);
    }


    @Test
    public void testCreateCartShouldBeSuccefull()
    {
    	assertTrue(requestToRESTService().startsWith("0|"));
    }
    
    @Test
    public void testCreate2CartResponseShouldBeDifferent()
    {
    	assertFalse(requestToRESTService().equals(requestToRESTService()));
    }
    
    @Test
    public void testCreateCartWithInvalidUserPasswordShoutReturn1WithError()
    {
   	 	assertTrue(requestToRESTServiceWrongUser().startsWith("1|"));
    }
    
    @Test
    public void testAddItemsToCartShouldReturn0OK(){
    	String result = this.requestToRESTService();
    	String idCart= result.substring(2);
 

    	String resultAddItem=target().path(addToCartResource)
				.queryParam("cartId", idCart)
				.queryParam("isbn", "12345")
				.queryParam("quantity", "3")
					.request().get(String.class);
    	
    	assertEquals("0|OK",resultAddItem);
    }
    
    @Test
    public void testAddItemsNoExistCartShouldFailWit1Error(){
    	String result = this.requestToRESTService();
    	String idCart= result.substring(2);
 

    	String resultAddItem=target().path(addToCartResource)
				.queryParam("cartId", idCart)
				.queryParam("isbn", "122225")
				.queryParam("quantity", "3")
					.request().get(String.class);
    	
    	assertTrue(resultAddItem.startsWith("1|"));
    }
    
    private String requestToRESTService() {
		return target().path(createCartResource)
    										.queryParam(USER_PARAMETER_DESCRIPTION, USER_NAME_PARAMETER)
    										.queryParam(PASSWORD_PARAMETER_DESCRIPTION, PASSWORD_PARAMETER)
    											.request().get(String.class);
	}
    
    private String requestToRESTServiceWrongUser() {
		return target().path(createCartResource)
    										.queryParam(USER_PARAMETER_DESCRIPTION, "oamedlunge")
    										.queryParam(PASSWORD_PARAMETER_DESCRIPTION, PASSWORD_PARAMETER)
    											.request().get(String.class);
	}
}
