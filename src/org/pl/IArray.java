package org.pl;

public interface IArray <T> {
	int GetCapacity (Integer capacity);
	int GetSize (Integer size);
	int GetAt (T obj, int pos);
	int SetAt (T obj, int pos);
}
