/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2014 - Amadeus s.a.s - All Rights Reserved.
 */
package com.amadeus.inr.sandbox.hotel.shopping.v2.conf;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import amadeus.inr.sandbox.ValidationException;

import com.amadeus.inr.sandbox.hotel.shopping.v2.output.Message;
import com.amadeus.inr.sandbox.hotel.shopping.v2.output.Message.LevelEnum;

/**
 * Raises an exception in the case of an input validation issue
 * 
 * @author tpearson
 * 
 */
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

  @Override
  @Produces("application/json")
  public Response toResponse(ValidationException e) {
    String message = e.getGiven() + " is not a valid " + e.getFieldName() + ". Expected " + e.getExpected();
    Message error = new Message(LevelEnum.ERROR, message);
    return Response.status(400).entity(error).build();
  }


}
