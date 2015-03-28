package com.example;

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

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
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
    	InsideRest inside = new InsideRest();
    	return "0|".concat(inside.createCart(username, password));
    }
    
}
