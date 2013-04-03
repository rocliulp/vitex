package org.pl.collection;

import org.pl.ErrorCode;
import org.pl.Out;

public class AppendableCollection <T>
extends Collection <T> implements IAppendableCollection <T> {
  /*
   * @ IElementAccessible
   */
  public int GetAt (Out <T> obj, int pos) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetCount (Out <Integer> outCount) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * @ IAppendableCollection
   */
  public int Append (T obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
