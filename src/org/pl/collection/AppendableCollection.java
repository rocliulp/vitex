package org.pl.collection;

public class AppendableCollection <T> extends Collection <T>
  implements IAppendableCollection <T> {
  /*
   * @ IAppendableCollection
   */
  int Append (T obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
  }
}
