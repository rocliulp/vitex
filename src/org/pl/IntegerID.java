/*
 * @author Paul
 */

package org.pl;

import org.pl.exception.OutOfMemoryException;

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
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IComparable
   */
  public int SmallerThan (Boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GreaterThan (Boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int SmallerEqual (Boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GreaterEqual (Boolean result, IComparable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IEquable
   */
  public int Equals (Boolean result, IEquable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int NotEquals (Boolean result, IEquable obj) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IInteger
   */
  public int ToInt () {
    return value;
  }
}
