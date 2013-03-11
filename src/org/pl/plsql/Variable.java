/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.global.Global;

public class Variable extends PLSQLStatement implements IVariable{
  /*
   * Private members
   */
  private String variableName = null;
  private String variableType = null;

  /*
   * Constructor
   */
  public Variable (String name, String type) throws NullParameterException {
    if (Global.IsStringNullOrEmpty(name)) throw new NullParameterException ("Variable (~)");
    if (Global.IsStringNullOrEmpty(type)) throw new NullParameterException ("Variable (~)");
    variableName = name;
    variableType = type;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    try {
      sql = new StringBuffer ();
      String line = String.format ("%s %s", variableName, variableType);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  /*
   * IVariable
   */
  public int GetVariableName (StringBuffer name) {
    if (Global.IsStringNullOrEmpty(variableName)) return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (variableName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetVariableType (StringBuffer type) {
    if (Global.IsStringNullOrEmpty(variableName)) return ErrorCode.EC_NULL_OBJECT;
    try {
      type = new StringBuffer (variableType);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
