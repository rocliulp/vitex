/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

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
    if (name == null) throw new NullParameterException ("Variable (~)");
    if (name == "") throw new NullParameterException ("Variable (~)");
    if (type == null) throw new NullParameterException ("Variable (~)");
    if (type == "") throw new NullParameterException ("Variable (~)");
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
    if (variableName == null) return ErrorCode.EC_NULL_OBJECT;
    if (variableName == "") return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (variableName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetVariableType (StringBuffer type) {
    if (variableType == null) return ErrorCode.EC_NULL_OBJECT;
    if (variableType == "") return ErrorCode.EC_NULL_OBJECT;
    try {
      type = new StringBuffer (variableType);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
