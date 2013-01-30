package org.pl.collection;

import org.pl.ErrorCode;

public class AppendableCollection <T> extends Collection <T>
  implements IAppendableCollection <T> {
  /*
   * @ IAppendableCollection
   */
  public int Append (T obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO: Writing
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
