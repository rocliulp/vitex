/*
 * @author Paul
 */

package org.pl;

public class Param <T> implements IParam <T> {
  /*
   * Private member
   */
  private T param = null;

  /*
   * IParam
   */
  public T GetParam () {
    return param;
  }

  public int SetParam (T prm) {
    this.param = prm;
    return ErrorCode.EC_OK;
  }
}
