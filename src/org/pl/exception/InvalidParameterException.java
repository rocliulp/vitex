package org.pl.exception;

import org.pl.ErrorCode;

public class InvalidParameterException extends Exception {
  /*
   * @ Constructor
   */
  public InvalidParameterException (java.lang.String errorMsg) {
    try {
      super (ErrorCode.EC_INVALID_PARAMETER, errorMsg);
    } catch (Exception e) {
      throw e;
    }
  }
}
