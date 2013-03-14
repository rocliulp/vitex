/*
 * @author Paul
 */

import org.pl.ErrorCode;

public class Out <T> implements IOut <T> {
  /*
   * Private members
   */
  T param = null;

  /*
   * IOut
   */
  public int GetParam (T param) {
    return param;
  }

  public int SetParam (T param) {
    if (param == null) return ErrorCode.EC_NULL_PARAMETER;
    this.param = param;
    return ErrorCode.EC_OK;
  }  
}
