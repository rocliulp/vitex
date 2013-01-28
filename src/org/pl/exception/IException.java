package org.pl.exception;

import org.pl.Integer;
import org.pl.String;

public interface IException {
  int GetErrorCode (Integer errorCode);
  int GetErrorMessage (String errorMsg);
}
