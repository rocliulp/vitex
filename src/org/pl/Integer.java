package org.pl;

public final class Integer extends Data implements IInteger {
  /*
   * @ Private members
   */
  private int value = 0;

  /*
   * @ Constructor
   */
  public Integer (int value) {
    this.value = value;
  }

  /*
   * @ IData
   */
  public int ToString (java.lang.String string) {
    try {
      string = java.lang.String.valueOf (value);
    } catch (Exception e) {
      string = null;
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }

  /*
   * @ IComparable
   */
  public int GreaterThan (boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    boolean isInstance = obj instanceof Integer;
    if (!isInstance) return ErrorCode.EC_INVALID_PARAMETER;
    Integer cmpObj = (Integer) obj;
    // TODO:
    if (value > cmpObj.value) {
    } else {
    }

    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerThan (boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GreaterEqual (boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerEqual (boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * @ IEquable
   */
  public int Equals (boolean result, IEquable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int NotEquals (boolean result, IEquable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IInteger
   */
  public int ToInt () {
    return value;
  }
}
