/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.global.Global;

public class FunctionReturnDeclaration
extends PLSQLStatement implements IFunctionReturnDeclaration {
  /*
   * Private members
   */
  private String returnType = null;

  /*
   * Constructor
   */
  public FunctionReturnDeclaration (String type) throws NullParameterException {
    if (Global.IsStringNullOrEmpty(type))
      throw new NullParameterException ("FunctionReturnDeclaration (~)");
    returnType = type;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty(returnType)) return ErrorCode.EC_NULL_OBJECT;
    try {
      sql = new StringBuffer ();
      String line = String.format ("RETURN %s", returnType);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  /*
   * IFunctionReturnDeclaration
   */
  public int GetReturnType (StringBuffer type) {
    if (Global.IsStringNullOrEmpty(returnType)) return ErrorCode.EC_NULL_PARAMETER;
    try {
      type = new StringBuffer (returnType);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
