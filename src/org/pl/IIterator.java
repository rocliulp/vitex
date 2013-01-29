package org.pl;

public interface IIterator <T> {
  int GetCurrent (T obj);
  int GetStep (Integer step);
  int GetElementAccessor (IElementAccessible <T> eAccessor);
  int MoveNext (Boolean end);
  int Reset ();
}
