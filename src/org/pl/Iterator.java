package org.pl;

import org.pl.exception;
import org.pl.Integer;

public class Iterator <T> extends Object implements IIterator <T> {
  /*
   * @ Private members
   */
  private int step = 1;
  private int pos = -1;
  private IArbitraryAccessor aAccessor = null;

  /*
   * @ Constructor
   */
  public Iterator (int step, IArbitraryAccessor aAccessor) {
    if (step < 1) throw new OutOfRangeException (); 
    if (aAccessor == null) throw new InvalidParameterException ();
    
    Integer aaCount = null;
    int ret = aAccessor.GetCount (aaCount);
    if (ret != ErrorCode.EC_OK)
      throw new Exception (ret, "Failed get the element count by iterator");
    if (step > count) throw new OutOfRangeException ();

    this.step = step;
    aAccessor = aAccessor;
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

  public int MoveNext (Boolean end) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int Reset () {
    pos = -1;
    return ErrorCode.EC_OK;
  }
}
