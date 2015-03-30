package com.example;

import javax.servlet.http.HttpSession;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cartsystem.InsideRest;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    private InsideRest _inside = new InsideRest();

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
    

    
    @Path("createCart")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String createCart(@DefaultValue("") @QueryParam("username") String username,
    					  @DefaultValue("") @QueryParam("password") String password)
    {
    	;
    	String returnMessage="";
    	try {
    		returnMessage="0|".concat(_inside.createCart(username, password));
		} catch (Exception e) {
			returnMessage="1|".concat(e.getMessage());
		}
    	return returnMessage;
    }
    
    @Path("addToCart")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addToCart(@DefaultValue("0") @QueryParam("cartId") String cartId,
			  @DefaultValue("0") @QueryParam("isbn") String isbn,
			  @DefaultValue("0") @QueryParam("quantity") int quantity)
    {
    	try {
    			_inside.addItem(isbn, quantity, cartId);
    			return "0|OK";
		} catch (Exception e) {
			return "1|".concat(e.getMessage());
		}

 
    }
    
}
