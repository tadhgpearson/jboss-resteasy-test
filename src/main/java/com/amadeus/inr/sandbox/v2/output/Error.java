/*
 * @1998-2014 - Amadeus s.a.s - All Rights Reserved.
 */
package com.amadeus.inr.sandbox.v2.output;

/**
 * @author tpearson
 *
 */
public class Error {

  final Integer status;

  final String message;

  String moreInfo;

  public Error(Integer status, String message, String moreInfo) {
    super();
    this.status = status;
    this.message = message;
    this.moreInfo = moreInfo;
  }

  public Error(Integer status, String message) {
    this(status, message, null);
  }

  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  public Integer getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "Error [status=" + status + ", message=" + message + ", moreInfo=" + moreInfo + "]";
  }

}
