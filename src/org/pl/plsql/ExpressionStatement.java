/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class ExpressionStatement
extends PLSQLBlock implements IExpressionStatement {
  /*
   * Private members
   */
  private String result = null;
  private String expression = null;

  /*
   * Constructor
   */
  public ExpressionStatement (String result, String expression)
  throws NullParameterException, OutOfMemoryException {
    if (result == null)
      throw new NullParameterException ("ExpressionStatement (~)");
    if (result == "")
      throw new NullParameterException ("ExpressionStatement (~)");
    if (expression == null)
      throw new NullParameterException ("ExpressionStatement (~)");
    if (expression == "")
      throw new NullParameterException ("ExpressionStatement (~)");
    try {
      this.result = result;
      this.expression = expression;
    } catch (Exception e) {
      throw new OutOfMemoryException ("ExpressionStatement (~)");
    }
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (result == null) return ErrorCode.EC_NULL_PARAMETER;
    if (result == "") return ErrorCode.EC_NULL_PARAMETER;
    if (expression == null) return ErrorCode.EC_NULL_PARAMETER;
    if (expression == "") return ErrorCode.EC_NULL_PARAMETER;

    String NEW_LINE = null;
    try {
      NEW_LINE = System.getProperty ("line.separator");
      String line = String.format ("%s := %s;%s", result, expression, NEW_LINE);
      sql.append (sql);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
