package org.pl.exception;

import org.pl.ErrorCode;

public class NullParameterException extends Exception {
  /*
   * @ Constructor
   */
  public NullParameterException (java.lang.String errorMsg) {
    super (ErrorCode.EC_NULL_PARAMETER, errorMsg);
  }
}
