package org.pl;

import org.pl.Integer;

/*
 * @summary This is the interface of Array object.
 * @param T Parameter as the generic type.
*/
public interface IArray <T> {
	int GetCapacity (Integer capacity);
	int GetLength (Integer size);
	int GetAt (T obj, int pos);
	int SetAt (T obj, int pos);
}
