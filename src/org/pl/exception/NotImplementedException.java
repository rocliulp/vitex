package org.pl.exception;

import org.pl.ErrorCode;

public class NotImplementedException extends Exception {
  /*
   * @ Constructor
   */
  public NotImplementedException (java.lang.String errorMsg) {
    super (ErrorCode.EC_NOT_IMPLEMENTED, errorMsg);
  }
}
