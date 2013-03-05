package org.pl;

public interface IComparable extends IEquable {
  int GreaterThan (boolean result, IComparable obj);
  int SmallerThan (boolean result, IComparable obj);
  int GreaterEqual (boolean result, IComparable obj);
  int SmallerEqual (boolean result, IComparable obj);
}
