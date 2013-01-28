package org.pl;

public interface IIterator <T> {
  int GetCurrent (T obj);
  int GetStep (Integer step);
  int GetArbitraryAccessor (IArbitraryAccessor <T> aAccessor);
  int MoveNext (Boolean end);
  int Reset ();
}
