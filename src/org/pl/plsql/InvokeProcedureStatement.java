/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class InvokeProcedureStatement
extends PLSQLBlock implements IInvokeProcedureStatement {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
