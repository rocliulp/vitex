/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.Object;
import org.pl.ErrorCode;

public abstract class PLSQLStatement extends Object implements IPLSQLStatement {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
