/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

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
    if (type == null)
      throw new NullParameterException ("FunctionReturnDeclaration (~)");
    if (type == "")
      throw new NullParameterException ("FunctionReturnDeclaration (~)");
    returnType = type;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (returnType == null) return ErrorCode.EC_NULL_OBJECT;
    if (returnType == "") return ErrorCode.EC_NULL_OBJECT;
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
    if (returnType == null) return ErrorCode.EC_NULL_PARAMETER;
    if (returnType == "") return ErrorCode.EC_NULL_PARAMETER;
    try {
      type = new StringBuffer (returnType);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
