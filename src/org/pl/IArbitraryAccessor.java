package org.pl;

public interface IArbitraryAccessor <T> {
  int GetCount (Integer count);
  int GetAt (T obj, int pos);
}
