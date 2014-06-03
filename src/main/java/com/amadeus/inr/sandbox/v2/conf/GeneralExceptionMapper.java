/*
 * @1998-2014 - Amadeus s.a.s - All Rights Reserved.
 */
package com.amadeus.inr.sandbox.v2.conf;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.amadeus.inr.sandbox.v2.output.Error;

/**
 * @author tpearson
 *
 */
@Provider
public class GeneralExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {

  @Override
  @Produces("application/json")
  public Response toResponse(Exception e) {
    String msg = "An unexpected server error occured. Try again in a few minutes, maybe it will work. " +
        "Otherwise, contact support with this response message";
    String moreInfo = "A " + e.getClass().getName() + " occurred at system time " + System.currentTimeMillis();
    e.printStackTrace();
    int statusCode = Status.INTERNAL_SERVER_ERROR.getStatusCode();
    Error error = new Error(statusCode, msg, moreInfo);
    return Response.status(statusCode).entity(error).build();
  }

}
