package org.pl;

public final class String extends Data {
  /*
   * @ Private members
   */
  private java.lang.String string;

  /*
   * @ Constructor
   */
  public String (java.lang.String string) {
    this.string = new java.lang.String (string);
  }
  
  /*
   * @ IData
   */
  public int ToString (java.lang.String string) {
    try {
      string = new java.lang.String (this.string);
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
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerThan (boolean result, IComparable obj) {
    if (obj == null ) return ErrorCode.EC_NULL_PARAMETER;
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
}
