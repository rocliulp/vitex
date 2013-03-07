/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class ProcedureBlock extends PLSQLBlock implements IProcedureStatement {
  /*
   * IPLSQLBlock
   */
  public int GetBlockName () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetBlockBody () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetBlockType () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IProcedureStatement
   */
  public int GetProcedureName () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetProcedureParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
