package org.pl;

import org.pl.Data;
import org.pl.String;

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
  public int ToString (String string) {
    if (bool == true) {
      string = new String ("TRUE");
      return ErrorCode.EC_OK;
    } else if (bool == false) {
      string = new String ("FALSE");
      return ErrorCode.EC_OK;
    } else {
      string = null;
      return ErrorCode.EC_IMPOSSIBLE_CASE;
    }
  }

  /*
   * @ IComparable
   */
  public int GreaterThan (Boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerThan (Boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GreaterEqual (Boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerEqual (Boolean result, IComparable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * @ IEquable
   */
  public int Equals (Boolean result, IEquable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int NotEquals (Boolean result, IEquable obj) {
    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}