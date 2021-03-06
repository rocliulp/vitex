package org.pl.collection;

import org.pl.Iterator;
import org.pl.IElementAccessible;
import org.pl.exception.OutOfRangeException;
import org.pl.exception.NullParameterException;
import org.pl.exception.Exception;
import org.pl.exception.InvalidConvertingException;

public class Enumerator <T> extends Iterator <T> {
  /*
   * @ Constructor
   */
  public Enumerator (IElementAccessible <T> eAccessor) throws
    OutOfRangeException, NullParameterException, Exception,
    InvalidConvertingException {
    super (1, eAccessor);
  }
}
