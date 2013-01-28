package org.pl.exception;

import org.pl.ErrorCode;

public class OutOfMemoryException extends Exception {
  /*
   * @ Constructor
   */
  public OutOfMemoryException (java.lang.String errorMsg) {
    super (ErrorCode.EC_OUT_OF_MEMORY, errorMsg);
  }
}
