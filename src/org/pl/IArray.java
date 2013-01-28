package org.pl;

/*
 * @summary This is the interface of Array object.
 * @param T Parameter as the generic type.
*/
public interface IArray <T> extends IArbitraryAccessor <T> {
	int GetCapacity (Integer capacity);
	int SetAt (T obj, int pos);
}
