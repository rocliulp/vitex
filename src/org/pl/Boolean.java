package org.pl;

public final class Boolean extends Data {
  /*
   * @ Private members
   */
  private boolean bool;

  /*
   * @ Constructor
   */
  public Boolean (boolean bool) {
    this.bool = bool;
  }

  /*
   * @ IData
   */
  public int ToString (java.lang.String string) {
    if (bool == true) {
      try {
        string = new java.lang.String ("TRUE");
      } catch (Exception e) {
        string = null;
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
      return ErrorCode.EC_OK;
    } else if (bool == false) {
      try {
        string = new java.lang.String ("FALSE");
      } catch (Exception e) {
        string = null;
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
      return ErrorCode.EC_OK;
    } else {
      string = null;
      return ErrorCode.EC_IMPOSSIBLE_CASE;
    }
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
}
