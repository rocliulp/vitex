package org.pl;

/*
 * @summary This is the interface of Array object.
 * @param T Parameter as the generic type.
*/


public interface IArray <T> extends IElementAccessible <T> {
	int GetCapacity (Out <java.lang.Integer> outCapacity);
	int SetAt (T obj, int pos);
}
