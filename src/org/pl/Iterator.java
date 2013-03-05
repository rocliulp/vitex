package org.pl;

import org.pl.exception.OutOfRangeException;
import org.pl.exception.NullParameterException;
import org.pl.exception.Exception;
import org.pl.exception.InvalidConvertingException;
import org.pl.Integer;

public class Iterator <T> extends Object implements IIterator <T> {
  /*
   * @ Private members
   */
  private int step = 1;
  private int pos = -1;
  private IElementAccessible eAccessor = null;

  /*
   * @ Constructor
   */
  public Iterator (int step, IElementAccessible <T> eAccessor)
    throws OutOfRangeException, NullParameterException, Exception {
    if (step < 1) throw new OutOfRangeException ("Step is invalid."); 
    if (eAccessor == null)
      throw new NullParameterException ("aAccesor is invalid.");
    
    Integer aaCount = null;
    int ret = eAccessor.GetCount (aaCount);
    if (ret != ErrorCode.EC_OK)
      throw new Exception (ret, "Failed get the element count by iterator");
    int count = aaCount.ToInt ();
    if (step > count)
      throw new OutOfRangeException ("step or aAccessor is invalid.");

    this.step = step;
    eAccessor = eAccessor;
  }

  /*
   * @ IIterator
   */
  public int GetCurrent (T obj) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetStep (Integer step) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetElementAccessor (IElementAccessible eAccessor) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int MoveNext (boolean end) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int Reset () {
    pos = -1;
    return ErrorCode.EC_OK;
  }
}
