/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class InsertStatement
extends PLSQLStatement implements IInsertStatement {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
