package org.pl;

import org.pl.Object;
import org.pl.ICollection;
import org.pl.CollNode;
import org.pl.ErrorCode;

public abstract class Collection <T> extends Object implements ICollection <T> {
  /*
   * Private members
   */
  protected CollNode item;

  /*
   * @ interface ICollection {
   */
	public int GetCount (Integer count) {
    // TODO:
    if (item == null) count = new Integer (0);
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
  
  public int GetAt (T obj, int pos) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
