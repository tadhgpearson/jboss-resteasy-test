/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2014 - Amadeus s.a.s - All Rights Reserved.
 */
package com.amadeus.inr.sandbox;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Redirection singleton for resteasy to expose all APIs under the base servlet
 * 
 * @author tpearson
 * 
 */
@ApplicationPath("/sandbox")
public class SandboxWebApp extends Application {
  private final Set<Object> singletons = new HashSet<>();

  public SandboxWebApp() {
    // Add new target endpoints here
    addResource(new com.amadeus.inr.sandbox.hotel.shopping.v2.Search());
  }

  @Override
  public Set<Object> getSingletons() {
    return Collections.unmodifiableSet(this.singletons);
  }

  protected Set<Object> addResource(Object resource) {
    this.singletons.add(resource);
    return this.singletons;
  }
}
