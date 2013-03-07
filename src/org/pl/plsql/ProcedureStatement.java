/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.Object;
import org.pl.ErrorCode;

public class ProcedureStatement extends Object implements IProcedureStatement {
  /*
   * IProcedureStatement
   */
  public int GetProcedureName () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetProcedureParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
