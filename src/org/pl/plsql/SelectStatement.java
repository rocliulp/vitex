/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class SelectStatement
extends PLSQLStatement implements ISelectStatement {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sqlP) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
