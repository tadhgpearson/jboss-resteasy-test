/**
 * 
 */
package com.amadeus.inr.sandbox.hotel.shopping.v2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.amadeus.inr.sandbox.v2.output.Error;

/**
 * Class to perform hotel shopping searches. Entry point to be called by the servlets
 * 
 * @author tpearson
 *
 */
@Path("/jboss")
public class Search {

  @GET
  @Path("/test")
	@Produces("application/json")
  public Error method(@QueryParam("apikey") String apiKey // Mandatory query parameters
  ) {
		
    Error rs = new Error(500, "This is a test for the " + apiKey);
    return rs;
  }


}
