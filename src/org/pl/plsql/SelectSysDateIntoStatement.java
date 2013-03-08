/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class SelectSysDateIntoStatement extends SelectIntoStatement {
  /*
   * Private members
   */
  private String variableName = null;

  /*
   * Constructor
   */
  public SelectSysDateIntoStatement (String name)
    throws NullParameterException, OutOfMemoryException {
    if (name == null)
      throw new NullParameterException ("SelectSysDateIntoStatement (~)");
    if (name == "")
      throw new NullParameterException ("SelectSysDateIntoStatement (~)");
    try {
      variableName = name;
    } catch (Exception e) {
      throw new OutOfMemoryException ("SelectSysDateIntoStatement (~)");
    }
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (variableName == null) return ErrorCode.EC_NULL_OBJECT;
    if (variableName == "") return ErrorCode.EC_NULL_OBJECT;

    String NEW_LINE = null;

    String line = null;
    try {
      NEW_LINE = System.getProperty ("line.separator");
      line = String.format (
          "SELECT SYSDATE INTO %s FROM DUAL;%s", variableName, NEW_LINE);
      sql = new StringBuffer (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
