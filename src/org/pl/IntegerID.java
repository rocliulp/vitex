/*
 * @author Paul
 */

package org.pl;

public class IntegerID extends ID implements IInteger {
  /*
   * Private members;
   */
  private int value = -1;

  /*
   * Constructor
   */
  public IntegerID (int id) {
    value = id;
  }

  /*
   * IData
   */
  public int ToString (java.lang.String string) {
    string = null;
    if (value < 0) return ErrorCode.EC_NULL_OBJECT;

    try {
      string = java.lang.String.valueOf (value);
    } catch (Exception e) {
      string = null;
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  /*
   * IComparable
   */
  public int SmallerThan (boolean result, IComparable obj) {
    if (value < 0) return ErrorCode.EC_NULL_OBJECT;

    if (obj == null) return ErrorCode.EC_NULL_PARAMETER;
    boolean isIID = obj instanceof IntegerID;
    if (!isIID) return ErrorCode.EC_INVALID_PARAMETER;
    IntegerID cmpObj = (IntegerID) obj;
    if (cmpObj.value < 0) return ErrorCode.EC_NULL_PARAMETER;

    if (this.value < cmpObj.value) {
      result = true;
    } else {
      result = false;
    }
    
    return ErrorCode.EC_OK;
  }

  public int GreaterThan (boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerEqual (boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GreaterEqual (boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IEquable
   */
  public int Equals (boolean result, IEquable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int NotEquals (boolean result, IEquable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IInteger
   */
  public int ToInt () {
    return value;
  }
}
