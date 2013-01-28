package org.pl.exception;

import org.pl.IObject;
import org.pl.ErrorCode;
import org.pl.Integer;
import org.pl.String;

public class Exception extends java.lang.Exception
  implements IObject, IException {
  /*
   * @ Private members
   */
  private int errorCode = ErrorCode.EC_UNEXPECTED_EXCEPTION;
  private java.lang.String errorMsg = "Unexpected exception.";

  /*
   * @ Constructor
   */
  public Exception (int errorCode, java.lang.String errorMsg) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  /*
   * @ IException
   */
  public int GetErrorCode (Integer errorCode) {
    try {
      errorCode = new Integer (this.errorCode);
    } catch (java.lang.Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetErrorMessage (String errorMsg) {
    try {
      errorMsg = new String (this.errorMsg);
    } catch (java.lang.Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
