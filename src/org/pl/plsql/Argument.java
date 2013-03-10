/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.global.Global;
import org.pl.ErrorCode;
import org.pl.environment.Environment;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class Argument extends PLSQLStatement {
  /*
   * Private member
   */
  private String value = null;
  private boolean isString= false;

  /*
   * Constructor
   */
  public Argument (String value, boolean isStr)
  throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty (value))
      throw new NullParameterException ("Argument (~)");
    
    try {
      this.value = value;
    } catch (Exception e) {
      throw new OutOfMemoryException ("Argument (~)");
    }
    isString = isStr;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty (value)) return ErrorCode.EC_NULL_OBJECT;

    try {
      String line = null;
      if (isString) {
        line = String.format ("\'%s\'", value);
      } else {
        line = String.format ("%s", value);
      }
      sql = new StringBuffer (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
