/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class FunctionStatement
extends ParametersBlock implements IFunctionStatement{
  /*
   * Private members
   */
  private String functionName = null;
  private FunctionReturnDeclaration functionReturn = null;

  /*
   * Constructor
   */
  public FunctionStatement (String name, String retType)
    throws NullParameterException, OutOfMemoryException {
    if (name == null)
      throw new NullParameterException ("FunctionStatement (~)");
    if (name == "")
      throw new NullParameterException ("FunctionStatement (~)");
    if (retType == null)
      throw new NullParameterException ("FunctionStatement (~)");
    if (retType == "")
      throw new NullParameterException ("FunctionStatement (~)");
    try {
      functionName = name;
      functionReturn = new FunctionReturnDeclaration (retType);
    } catch (Exception e) {
      throw new OutOfMemoryException ("FunctionStatement (~)");
    }
  }

  /*
   * IFunctionStatement
   */
  public int GetFunctionName (StringBuffer name) {
    if (functionName == null) return ErrorCode.EC_NULL_OBJECT;
    if (functionName == "") return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (functionName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetFunctionReturn (FunctionReturnDeclaration retDec) {
    if (functionReturn == null) return ErrorCode.EC_NULL_OBJECT;
    retDec = functionReturn;
    return ErrorCode.EC_OK;
  }

  public int GetFunctionParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    String NEW_LINE = null;
    try {
      NEW_LINE  = System.getProperty ("line.separator");
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    int ret = 0;
    StringBuffer sb = new StringBuffer ();

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
    ret = retDec.GetSQL (sb);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      line = String.format ("%s;%s",sb.toString (), NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
