/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.global.Global;
import org.pl.environment.Environment;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class ProcedureBlockHead extends ParametersBlock {
  /*
   * Private members
   */
  private String procedureName = null;

  /*
   * Constructor
   */
  public ProcedureBlockHead (String name)
  throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty (name))
      throw new NullParameterException ("ProcedureBlockHead (~)");
    try {
      procedureName = name;
    } catch (Exception e) {
      throw new OutOfMemoryException ("OutOfMemoryException (~)");
    }
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty (procedureName))
      return ErrorCode.EC_NULL_OBJECT;
    
    try {
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    String line = null;
    try {
      line = String.format ("PROCEDURE %s ", procedureName);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    StringBuffer sb = new StringBuffer ();
    int ret = super.GetSQL (sb);
    if (ret != ErrorCode.EC_OK) return ret;
    try {
      sql.append (sb);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    try {
      line = String.format (" IS%s", Environment.NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    
    return ErrorCode.EC_OK;
  }
}
