package org.pl;

import org.pl.Object;
import org.pl.ICollection;
import org.pl.CollNode;
import org.pl.ErrorCode;

public class Collection <T> extends Object implements ICollection <T> {
  /*
   * Private members
   */
  private CollNode item;
  private int collNodeCount;

  /*
   * @ interface ICollection {
   */
	public int GetCount (Integer count) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
	}
  
  public int GetAt (T obj, int pos) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
  /*
   * @ interface ICollection }
   */
}
