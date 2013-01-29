package org.pl;

public class Array <T> extends Object implements IArray <T> {
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
