/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class SelectStatement
extends PLSQLBlock implements ISelectStatement {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
