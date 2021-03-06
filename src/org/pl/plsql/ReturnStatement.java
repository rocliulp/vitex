/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.global.Global;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class ReturnStatement extends PLSQLStatement {
  /*
   * Private members
   */
  private String value;
  private boolean isString;

  /*
   * Constructor
   */
  public ReturnStatement (String value, boolean isStr)
  throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty (value))
      throw new NullParameterException ("ReturnStatement (~)");
    try {
      this.value = value;
    } catch (Exception e) {
      throw new OutOfMemoryException ("ReturnStatement (~)");
    }
    isString = isStr;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty (value)) return ErrorCode.EC_NULL_OBJECT;
    String line = null;
    try {
      if (isString) {
        line = String.format ("\'%s\'", value);
      } else {
        line = String.format ("%s", value);
      }
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
