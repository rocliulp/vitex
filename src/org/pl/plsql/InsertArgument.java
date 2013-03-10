/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;
import org.pl.exception.OutOfMemoryException;
import org.pl.global.Global;

public class InsertArgument extends PLSQLStatement implements IInsertArgument {
  /*
   * Private members
   */
  private String columnName = null;
  private String columnValue = null;

  /*
   * Constructor
   */
  public InsertArgument (String name, String value)
  throws NullParameterException, OutOfMemoryException {
    if (Global.IsStringNullOrEmpty (name))
      throw new NullParameterException ("InsertArgument (~)");
    if (Global.IsStringNullOrEmpty (value))
      throw new NullParameterException ("InsertArgument (~)");
    try {
      columnName = name;
      columnValue = value;
    } catch (Exception e) {
      throw new OutOfMemoryException ("InsertArgument (~)");
    }
  }

  /*
   * IInsertArgument
   */
  public int GetColumnName (StringBuffer name) {
    if (Global.IsStringNullOrEmpty (columnName))
      return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (columnName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  public int GetColumnValue (StringBuffer value) {
    if (Global.IsStringNullOrEmpty (columnValue))
      return ErrorCode.EC_NULL_OBJECT;
    try {
      value = new StringBuffer (columnValue);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
