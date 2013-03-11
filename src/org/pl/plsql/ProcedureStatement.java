/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.Object;
import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.global.Global;

public class ProcedureStatement
extends ParametersBlock implements IProcedureStatement {
  /*
   * Private members
   */
  private String procedureName = null;

  /*
   * Constructor
   */
  public ProcedureStatement (String name) throws NullParameterException {
    if (Global.IsStringNullOrEmpty(name))
      throw new NullParameterException ("ProcedureStatement (~)");
    procedureName = name;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty(procedureName)) return ErrorCode.EC_NULL_OBJECT;
    String NEW_LINE = null;
    try {
      sql = new StringBuffer ();
      NEW_LINE = System.getProperty ("line.separator");
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
      line = String.format (";%s", NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  /*
   * IProcedureStatement
   */
  public int GetProcedureName (StringBuffer name) {
    if (Global.IsStringNullOrEmpty(procedureName)) return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (procedureName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }

  public int GetProcedureParameters () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
