/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class FunctionBlock extends PLSQLBlock implements IFunctionStatement {
  /*
   * IPLSQLFunctionStatement
   */
  public int GetFunctionName () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetFunctionReturn () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetFunctionParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
