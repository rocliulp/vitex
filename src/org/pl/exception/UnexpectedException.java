package org.pl.exception;

public class UnexpectedException extends Exception {
  /*
   * @ Constructor
   */
  public UnexpectedException (int errorCode, java.lang.String errorMsg) {
    super(errorCode, errorMsg);
  }
}
