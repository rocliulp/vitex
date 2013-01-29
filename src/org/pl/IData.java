package org.pl;

import org.pl.exception.InvalidConvertingException;

public interface IData {
  int ToString (String string);
  int ToInt () throws InvalidConvertingException;
  boolean ToBoolean () throws InvalidConvertingException;
}
