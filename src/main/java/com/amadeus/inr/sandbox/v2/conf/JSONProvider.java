/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2014 - Amadeus s.a.s - All Rights Reserved.
 */
package com.amadeus.inr.sandbox.v2.conf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

import com.amadeus.inr.sandbox.hotel.shopping.v2.conf.serializer.BigDecimalSerializer;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author tpearson
 * 
 *         Overwrite properties of Jackson's default JSON serialization
 */
@Provider
public class JSONProvider extends ResteasyJackson2Provider {

  @Override
  public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType json,
      MultivaluedMap<String, Object> headers, OutputStream body) throws IOException {

    ObjectMapper mapper = locateMapper(type, json);
    configureOutputOptions(mapper);

    SimpleModule serializationModule = buildSerializationModule();
    mapper.registerModule(serializationModule);

    super.writeTo(value, type, genericType, annotations, json, headers, body);
  }

  private SimpleModule buildSerializationModule() {
    SimpleModule serializationModule = new SimpleModule();
    serializationModule.addSerializer(BigDecimal.class, new BigDecimalSerializer());
    return serializationModule;
  }

  private void configureOutputOptions(ObjectMapper mapper) {
    mapper.setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());
    mapper.enable(SerializationFeature.INDENT_OUTPUT, SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
    mapper.setSerializationInclusion(Include.NON_NULL);
  }

}
