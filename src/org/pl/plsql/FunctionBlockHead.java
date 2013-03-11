/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;
import org.pl.global.Global;

public class FunctionBlockHead
extends ParametersBlock implements IFunctionStatement {
  /*
   * Private members
   */
  private String functionName = null;
  private FunctionReturnDeclaration functionReturn = null;

  /*
   * Constructor
   */
  public FunctionBlockHead (String name, String retType)
    throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty(name))
      throw new NullParameterException ("FunctionBlockHead (~)");
    if (Global.IsStringNullOrEmpty(retType))
      throw new NullParameterException ("FunctionBlockHead (~)");
    try {
      functionName = name;
      functionReturn = new FunctionReturnDeclaration (retType);
    } catch (Exception e) {
      throw new OutOfMemoryException ("FunctionBlockHead (~)");
    }
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty(functionName)) return ErrorCode.EC_NULL_OBJECT;
    String NEW_LINE = System.getProperty ("line.separator");

    try {
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    String line = null;
    try {
      line = String.format ("FUNCTION %s ", functionName);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    int ret = 0;
    StringBuffer sb = new StringBuffer ();
    ret = super.GetSQL (sb);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      sql.append (sb);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    FunctionReturnDeclaration retDec = null;
    ret = GetFunctionReturn (retDec);
    if (ret != ErrorCode.EC_OK) return ret;
    ret = retDec.GetReturnType (sb);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      line = String.format ("RETURN %s IS%s", sb.toString (), NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    
    return ErrorCode.EC_OK;
  }

  /*
   * IFunctionStatement
   */
  public int GetFunctionName (StringBuffer name) {
    if (Global.IsStringNullOrEmpty(functionName)) return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (functionName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetFunctionParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetFunctionReturn (FunctionReturnDeclaration retDec) {
    if (functionReturn == null) return ErrorCode.EC_NULL_OBJECT;
    retDec = functionReturn;
    return ErrorCode.EC_OK;
  }
}
