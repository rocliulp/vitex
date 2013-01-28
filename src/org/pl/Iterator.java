package org.pl;

public class Iterator <T> extends Object implements IIterator <T> {
  /*
   * @ Private members
   */
  private int step = 1;
  private int pos = -1;

  /*
   * @ Constructor
   */
  public Iterator (int step) {
    this.step = step;
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
