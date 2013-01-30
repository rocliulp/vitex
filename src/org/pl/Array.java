package org.pl;

import org.pl.exception.OutOfRangeException;

public class Array <T> extends Object implements IArray <T> {
  /*
   * @ Private members
   */
  private int capacity = 0;
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
	public int GetCapacity (Integer capacity) {
    if (array == null) {
      try {
        capacity = new Integer (0);
      } catch (Exception e) {
        capacity = null;
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    } else {
      try {
        capacity = new Integer (this.capacity);
      } catch (Exception e) {
        capacity = null;
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    }
    return ErrorCode.EC_OK;
	}

	public int SetAt (T obj, int pos) {
    if (pos < 0) return ErrorCode.EC_OUT_OF_RANGE;
    if (pos > capacity - 1) return ErrorCode.EC_OUT_OF_RANGE;
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;

    array [pos] = obj;
		return ErrorCode.EC_OK;
	}

  /*
   * @ IElementAccessible
   * @ TODO: Check if this is necessary.
   */
	public int GetCount (Integer count) {
		return GetCapacity (count);
	}

	public int GetAt (T obj, int pos) {
    if (pos < 0) return ErrorCode.EC_OUT_OF_RANGE;
    if (pos > capacity - 1) return ErrorCode.EC_OUT_OF_RANGE;
    obj = array [pos];
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
}
