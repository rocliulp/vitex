package org.pl;

public interface ICollection <T> {
	int GetCount (Integer size);
	int GetAt (T obj, int pos);
}
