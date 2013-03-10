/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

public class ProcedureBlock extends PLSQLBlock implements IProcedureStatement {
  /*
   * Private members
   */
  private ProcedureBlockHead procedureBlockHead = null;
  private DeclarationBlock declarationBlock = null;
  private BeginEndBlock beginEndBlock = null;

  /*
   * Constructor
   */
  public ProcedureBlock (
      ProcedureBlockHead head,
      DeclarationBlock decl,
      BeginEndBlock beb) throws NullParameterException {
    if (head == null) throw new NullParameterException ("ProcedureBlock (~)");
    if (beb == null) throw new NullParameterException ("ProcedureBlock (~)");
    procedureBlockHead = head;
    declarationBlock = decl;
    beginEndBlock = beb;
  }
  /*
   * IProcedureStatement
   */
  public int GetProcedureName (StringBuffer name) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetProcedureParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (procedureBlockHead == null) return ErrorCode.EC_NULL_OBJECT;
    if (beginEndBlock == null) return ErrorCode.EC_NULL_OBJECT;

    try {
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    StringBuffer sb = new StringBuffer ();
    int ret = procedureBlockHead.GetSQL (sb);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      sql.append (sb);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    if (declarationBlock != null) {
      ret = declarationBlock.GetSQL (sb);
      if (ret != ErrorCode.EC_OK) return ret;
      try {
        sql.append (sb);
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    }

    ret = beginEndBlock.GetSQL (sb);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      sql.append (sb);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
