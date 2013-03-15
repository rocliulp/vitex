/*
 * @author Paul
 */

package org.pl;

public class Out <T> implements IOut <T> {
  /*
   * Private members
   */
  T param = null;

  /*
   * IOut
   */
  public T GetParam () {
    return param;
  }

  public int SetParam (T param) {
    if (param == null) return ErrorCode.EC_NULL_PARAMETER;
    this.param = param;
    return ErrorCode.EC_OK;
  }  
}
