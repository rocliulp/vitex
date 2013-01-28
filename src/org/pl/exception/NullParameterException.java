package org.pl.exception;

import org.pl.ErrorCode;

public class NullParameterException extends Exception {
  /*
   * @ Constructor
   */
  public NullParameterException (java.lang.String errorMsg) {
    try {
      super (ErrorCode.EC_NULL_PARAMETER, errorMsg);
    } catch (Exception e) {
      throw e;
    }
  }
}
