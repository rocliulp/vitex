package org.pl.exception;

import org.pl.ErrorCode;

public class CanNotInstantiateStaticClassException extends Exception {
  /*
   * @ Constructor
   */
  public CanNotInstantiateStaticClassException (String errorMsg) {
    super (ErrorCode.EC_CAN_NOT_INSTANTIATE_STATIC_CLASS_EXCEPTION, errorMsg);
  }
}
