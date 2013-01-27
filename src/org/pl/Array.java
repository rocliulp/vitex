package org.pl;

public class Array <T> extends Object implements IArray <T> {
/*
 * @ interface IArray <T> {
*/
	public int GetCapacity (Integer capacity) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

	public int GetCount (Integer size) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

	public int SetAt (T obj, int pos) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

	public int GetAt (T obj, int pos) {
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
/*
 * @ interface IArray <T> }
*/
}
