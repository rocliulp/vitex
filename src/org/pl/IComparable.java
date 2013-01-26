package org.pl;

import org.pl.IEquable;

public interface IComparable extends IEquable {
  int GreaterThan (Boolean result, IComparable obj);
  int SmallerThan (Boolean result, IComparable obj);
  int GreaterEqual (Boolean result, IComparable obj);
  int SmallerEqual (Boolean result, IComparable obj);
}
