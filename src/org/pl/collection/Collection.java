package org.pl.collection;

import org.pl.Object;
import org.pl.ErrorCode;

public abstract class Collection <T> extends Object implements ICollection <T> {
  /*
   * Private members
   */
  protected CollNode <T> item = null;
  protected int nodeCapacity = 100;
  protected int count = 0;

  /*
   * @ interface ICollection {
   */
	public int GetCount (Integer count) {
    try {
      count = new Integer (this.count);
    } catch (Exception e) {
      count = null;
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
  
  public int GetAt (T obj, int pos) {
    if (pos < 0) return ErrorCode.EC_OUT_OF_RANGE;
    if (pos > count) return ErrorCode.EC_OUT_OF_RANGE;
    if (item == null) return ErrorCode.EC_NULL_OBJECT;
    if (nodeCapacity < 1) return ErrorCode.EC_NULL_OBJECT;

    int ret = 0;
    int i = -1;
    CollNode node = item;
    int nodePos = 0;
    if (pos > nodeCapacity) {
      nodePos = pos / nodeCapacity;
      pos = pos / nodeCapacity;

      while (++i < nodePos) {
        ret = node.GetSuccessor (node);
        if (ret != ErrorCode.EC_OK) {
          node = null;
          return ret;
        }
      }
    }

    ret = node.GetAt (obj, pos);
    if (ret != ErrorCode.EC_OK) {
      obj = null;
      return ret;
    }

    return ErrorCode.EC_OK;
  }
}
