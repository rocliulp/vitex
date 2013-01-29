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
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

	public int SetAt (T obj, int pos) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

  /*
   * @ IElementAccessible
   */
	public int GetCount (Integer count) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

	public int GetAt (T obj, int pos) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
}
