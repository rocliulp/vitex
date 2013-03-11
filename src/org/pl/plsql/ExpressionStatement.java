/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;
import org.pl.global.Global;

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
    if (Global.IsStringNullOrEmpty(result))
      throw new NullParameterException ("ExpressionStatement (~)");
    if (Global.IsStringNullOrEmpty(expression))
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
    if (Global.IsStringNullOrEmpty(result)) return ErrorCode.EC_NULL_PARAMETER;
    if (Global.IsStringNullOrEmpty(expression)) return ErrorCode.EC_NULL_PARAMETER;

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
