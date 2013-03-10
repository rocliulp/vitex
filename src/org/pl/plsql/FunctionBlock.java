/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

public class FunctionBlock extends PLSQLBlock implements IFunctionStatement {
  /*
   * Private members
   */
  private FunctionBlockHead functionBlockHead = null;
  private DeclarationBlock declarationBlock = null;
  private BeginEndBlock beginEndBlock = null;

  /*
   * Constructor
   */
  public FunctionBlock (
      FunctionBlockHead head,
      DeclarationBlock decl,
      BeginEndBlock bec) throws NullParameterException {
    if (head == null) throw new NullParameterException ("FunctionBlock (~)");
    if (bec == null) throw new NullParameterException ("FunctionBlock (~)");
    functionBlockHead = head;
    declarationBlock = decl;
    beginEndBlock = bec;
  }
  /*
   * IPLSQLFunctionStatement
   */
  public int GetFunctionName (StringBuffer name) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetFunctionReturn (FunctionReturnDeclaration retDec) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetFunctionParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (functionBlockHead == null) return ErrorCode.EC_NULL_OBJECT;
    if (beginEndBlock == null) return ErrorCode.EC_NULL_OBJECT;
    try {
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    
    StringBuffer sb = new StringBuffer ();
    int ret = functionBlockHead.GetSQL (sb);
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

    ret = beginEndBlock.GetSQL (sql);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      sql.append (sb);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
