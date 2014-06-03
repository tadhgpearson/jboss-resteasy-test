/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2014 - Amadeus s.a.s - All Rights Reserved.
 */
package com.amadeus.inr.sandbox.v2.conf.serializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Customized serializer for {@link BigDecimal} objects to ensure that they are always rendered as a string
 * 
 * @author tpearson
 * 
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

  @Override
  public void serialize(BigDecimal val, JsonGenerator gen, SerializerProvider prov) throws IOException,
      JsonProcessingException {
    String out = format(val);
    gen.writeString(out);
  }

  static public String format(BigDecimal val) {
    String out = DECIMAL_FORMAT.format(val);
    return out;
  }

}
