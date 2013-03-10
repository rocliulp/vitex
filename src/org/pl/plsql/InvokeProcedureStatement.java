/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;
import org.pl.global.Global;
import org.pl.environment.Environment;

public class InvokeProcedureStatement
extends PLSQLBlock implements IInvokeProcedureStatement {
  /*
   * Private members
   */
  private String packageName = null;
  private String procedureName = null;

  /*
   * Constructor
   */
  public InvokeProcedureStatement (String pkgName, String pcdName)
  throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty (pkgName))
      throw new NullParameterException ("InvokeProcedureStatement (~)");
    if (Global.IsStringNullOrEmpty (pcdName))
      throw new NullParameterException ("InvokeProcedureStatement (~)");
    try {
      packageName = pkgName;
      procedureName = pcdName;
    } catch (Exception e) {
      throw new OutOfMemoryException ("InvokeProcedureStatement (~)");
    }
  }
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty (packageName))
      return ErrorCode.EC_NULL_OBJECT;
    if (Global.IsStringNullOrEmpty (procedureName))
      return ErrorCode.EC_NULL_OBJECT;

    String line = null;
    try {
      sql = new StringBuffer ();
      line = String.format ("%s.%s (%s",
          packageName, procedureName, Environment.NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    Integer count = -1;
    int ret = GetCount (count);
    if (ret != ErrorCode.EC_OK) return ret;
    int i = -1;
    while (++i < count) {
      Argument arg = null;
      ret = GetAt (arg, i);
      if (ret != ErrorCode.EC_OK) return ret;
      StringBuffer sb = new StringBuffer ();
      ret = arg.GetSQL (sb);
      if (ret != ErrorCode.EC_OK) return ret;
      if (i == count - 1) {
        line = String.format ("%s%s", sb.toString (), Environment.NEW_LINE);
      } else {
        line = String.format ("%s,%s", sb.toString (), Environment.NEW_LINE);
      }
      sql.append (line);
    }

    try {
      line = String.format (");%s", Environment.NEW_LINE);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
