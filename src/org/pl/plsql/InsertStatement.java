/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.global.Global;
import org.pl.environment.Environment;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;

public class InsertStatement
extends PLSQLBlock implements IInsertStatement {
  /*
   * Private member
   */
  private String tableName;
  
  /*
   * Constructor
   */
  public InsertStatement (String tableName)
  throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty (tableName))
      throw new NullParameterException ("InsertStatement (~)");
    try {
      this.tableName = tableName;
    } catch (Exception e) {
      throw new OutOfMemoryException ("InsertStatement (~)");
    }
  }

  /*
   * IPLSQLStatement
   */
  private int FormatColumnsOrValues(
      StringBuffer sql,
      String nameValue,
      int count,
      int i) {
    if (sql == null) return ErrorCode.EC_NULL_PARAMETER;
    if (Global.IsStringNullOrEmpty (nameValue))
      return ErrorCode.EC_NULL_PARAMETER;
    if (count < 1) return ErrorCode.EC_NULL_PARAMETER;
    if (i < 0) return ErrorCode.EC_OUT_OF_RANGE;
    if (i > count -1) return ErrorCode.EC_OUT_OF_RANGE;
    String line = null;

    try {
      if (count == 1){
        line = String.format ("%s", nameValue.toString ());
      } else {
        if (i == 1) {
          line = String.format ("%s,%s",
              nameValue.toString (), Environment.NEW_LINE);
        } else if (i == count - 1) {
          line = String.format (" %s%s",
              nameValue.toString (), Environment.NEW_LINE);
        } else {
          line = String.format (" %s,%s",
              nameValue.toString (), Environment.NEW_LINE);
        }
      }
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetSQL (StringBuffer sql) {
    if (Global.IsStringNullOrEmpty (tableName)) return ErrorCode.EC_NULL_OBJECT;
    Integer count = null;
    int ret = GetCount (count);
    if (ret != ErrorCode.EC_OK) return ret;
    if (count < 1) return ErrorCode.EC_NULL_OBJECT;
    String line = null;
    try {
      sql = new StringBuffer ();
      line = String.format ("INSERT INTO %s (", tableName);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    int i = -1;
    while (++i < count) {
      InsertArgument arg = null;
      ret = GetAt (arg, i);
      if (ret != ErrorCode.EC_OK) return ret;
      StringBuffer sb = new StringBuffer ();
      ret = arg.GetColumnName (sb);
      if (ret != ErrorCode.EC_OK) return ret;
      try {
        line = sb.toString ();
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
      ret = FormatColumnsOrValues (sql, line, count, i);
      if (ret != ErrorCode.EC_OK) return ret;
    }

    try {
      line = String.format (") VALUES (");
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    i= -1;
    while (++i < count) {
      InsertArgument arg = null;
      ret = GetAt (arg, i);
      if (ret != ErrorCode.EC_OK) return ret;
      StringBuffer sb = new StringBuffer ();
      ret = arg.GetColumnValue (sb);
      if (ret != ErrorCode.EC_OK) return ret;
      try {
        line = sb.toString ();
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
      ret = FormatColumnsOrValues (sql, line, count, i);
      if (ret != ErrorCode.EC_OK) return ret;
    }

    try {
      line = String.format (");%s", Environment.NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
