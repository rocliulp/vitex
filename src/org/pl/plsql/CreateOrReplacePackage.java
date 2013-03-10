/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

public class CreateOrReplacePackage
extends PLSQLBlock implements ICreateOrReplacePackage {
  /*
   * Private members
   */
  private String packageName = null;

  /*
   * Constructor
   */
  public CreateOrReplacePackage (String name) throws NullParameterException {
    if (name == null)
      throw new NullParameterException ("CreateOrReplacePackage (~)");
    if (name == "")
      throw new NullParameterException ("CreateOrReplacePackage (~)");
    packageName = name;
  }
  
  /*
   * IPLSQLBlock
   */
  public int GetSQL (StringBuffer sql) {
    String NEW_LINE = System.getProperty ("line.separator");
    sql = new StringBuffer ();

    String line = null;
    try {
      line = String.format (
          "CREATE OR REPLACE PACKAGE %s AS%s", packageName, NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    Integer count = null;
    int ret = GetCount (count);
    if (ret != ErrorCode.EC_OK) return ret;
    int i = -1;
    while (++i < count) {
      IPLSQLStatement stm = null;
      ret = GetAt (stm, i);
      if (ret != ErrorCode.EC_OK) return ret;
      StringBuffer sb = new StringBuffer ();
      ret = stm.GetSQL (sb);
      if (ret != ErrorCode.EC_OK) return ret;
      try {
        sql.append (sb);
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    }

    try {
      line = String.format ("END %s;%s", packageName, NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }

  /*
   * ICreateOrReplacePackage
   */
  public int GetPackageName (StringBuffer name) {
    if (packageName == null) return ErrorCode.EC_NULL_OBJECT;
    if (packageName == "") return ErrorCode.EC_NULL_OBJECT;
    try {
      name = new StringBuffer (packageName);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }
    return ErrorCode.EC_OK;
  }
}
