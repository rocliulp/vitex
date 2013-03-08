/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

public class DeclarationStatement extends Variable {
  /*
   * Constructor
   */
  public DeclarationStatement (String name, String type)
    throws NullParameterException {
    super(name,type);
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    String NEW_LINE = null;
    try {
      NEW_LINE = System.getProperty ("line.separator");
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    StringBuffer sb = null;
    int ret = super.GetSQL (sb);
    try {
      String line = String.format ("%s;%s", sb.toString (), NEW_LINE);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
