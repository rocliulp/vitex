package org.pl;

import org.pl.Data;
import org.pl.Boolean;

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
  public int ToString (String string) {
    string = new String (this.string);
    return ErrorCode.EC_OK;
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
    if (obj == null ) return ErrorCode.EC_NULL_PARAMETER;
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
