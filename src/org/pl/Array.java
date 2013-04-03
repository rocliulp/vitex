package org.pl;

import org.pl.exception.OutOfRangeException;

public class Array <T> extends Object implements IArray <T> {
  /*
   * @ Private members
   */
  private int count = 0;
  private T [] array = null;

  /*
   * @ Constructor
   */
  @SuppressWarnings ({"unchecked"})
  public Array (int capacity) throws OutOfRangeException {
    if (capacity < 1)
      throw new OutOfRangeException ("Capacity of array must greater than 0.");
    array = (T []) new Object [capacity];
  }

  /*
   * @ IArray <T>
   */
	public int GetCapacity (Out <java.lang.Integer> outCapacity) {
    if (outCapacity == null) return ErrorCode.EC_NULL_PARAMETER;

    java.lang.Integer capacity = null;
    if (array == null) {
      try {
        capacity = new java.lang.Integer (0);
      } catch (Exception e) {
        capacity = null;
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    } else {
      try {
        capacity = new java.lang.Integer (array.length);
      } catch (Exception e) {
        capacity = null;
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    }
    outCapacity.SetParam (capacity);

    return ErrorCode.EC_OK;
	}

	public int SetAt (T obj, int pos) {
    Out <java.lang.Integer> outCount = new Out <java.lang.Integer> ();
    int ret = GetCount (outCount);
    if (ret != ErrorCode.EC_OK) return ret;
    int count = outCount.GetParam ();
    if (pos != count) return ret;

    Out <java.lang.Integer> outCapacity = new Out <java.lang.Integer> ();
    ret = GetCapacity (outCapacity);
    if (ret != ErrorCode.EC_OK) return ret;
    int capacity = outCapacity.GetParam ();
    if (pos > capacity - 1) return ret;

    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;

    array [pos] = obj;
    ++ (this.count);
		return ErrorCode.EC_OK;
	}

  /*
   * @ IElementAccessible
   */
	public int GetCount (Out <java.lang.Integer> outCount) {
    if (outCount == null) return ErrorCode.EC_NULL_PARAMETER;

    java.lang.Integer count = null;
    try {
      count = new java.lang.Integer (this.count);
    } catch (Exception e) {
      count = null;
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    outCount.SetParam (count);

		return ErrorCode.EC_OK;
	}

	public int GetAt (Out <T> outObj, int pos) {
    if (pos < 0) return ErrorCode.EC_OUT_OF_RANGE;
    Out <java.lang.Integer> outCount = new Out <java.lang.Integer> ();
    int ret = GetCount (outCount);
    if (ret != ErrorCode.EC_OK) return ret;
    int count = outCount.GetParam ();
    if (pos > count - 1) return ErrorCode.EC_OUT_OF_RANGE;
    
    outObj.SetParam (array [pos]);
		return ErrorCode.EC_OK;
	}
}
