package org.pl.exception;

import org.pl.ErrorCode;

public class OutOfRangeException extends Exception {
  /*
   * @ Constructor
   */
  public OutOfRangeException (java.lang.String errorMsg) {
    super (ErrorCode.EC_OUT_OF_RANGE, errorMsg);
  }
}
