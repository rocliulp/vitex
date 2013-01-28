package org.pl.exception;

import org.pl.ErrorCode;

public class InvalidConvertingException extends Exception {
  /*
   * @ Constructor
   */
  public InvalidConvertingException (java.lang.String errorMsg) {
    super (ErrorCode.EC_FAILED_CONVERTING, errorMsg);
  }
}
