package com.example;

import java.io.Console;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.MyResource;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MyResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        final String responseMsg = target().path("myresource").request().get(String.class);

        assertEquals("Hello, Heroku!", responseMsg);
    }
    
    @Test
    public void testCreateCartShouldBeSuccefull()
    {
    	String targetResource="myresource/createCart";
    	final String responsCreateCart = target().path(targetResource)
    										.queryParam("username", "oscar")
    										.queryParam("password", "Lagarto33")
    											.request().get(String.class);
    	assertTrue(responsCreateCart.startsWith("0|"));
    }
    
    @Test
    public void testCreate2CartResponseShouldBeDifferent()
    {
    	String targetResource="myresource/createCart";
    	 String responsCreateCart1 = target().path(targetResource)
    										.queryParam("username", "oscar")
    										.queryParam("password", "Lagarto33")
    											.request().get(String.class);
    	
    	 String responsCreateCart2 = target().path(targetResource)
				.queryParam("username", "oscar")
				.queryParam("password", "Lagarto33")
					.request().get(String.class);
    	
    	assertTrue(responsCreateCart1.startsWith("0|"));
    	assertTrue(responsCreateCart2.startsWith("0|"));
    	assertFalse(responsCreateCart1.equals(responsCreateCart2));
    }
}
