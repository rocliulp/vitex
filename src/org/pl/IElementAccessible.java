package org.pl;

public interface IElementAccessible <T> {
  int GetCount (Out <java.lang.Integer> count);
  int GetAt (Out <T> outObj, int pos);
}
