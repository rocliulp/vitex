/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

public class CreateOrReplacePackageBody extends PLSQLBlock {
  /*
   * Private members
   */
  private String packageName;

  /*
   * Constructor
   */
  public CreateOrReplacePackageBody (String name)
    throws NullParameterException {
    if (name == null)
      throw new NullParameterException ("CreateOrReplacePackageBody (~)");
    if (name == "")
      throw new NullParameterException ("CreateOrReplacePackageBody (~)");
    packageName = name;
  }

  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    String NEW_LINE = System.getProperty ("line.separator");
    sql = new StringBuffer ();

    String line = null;
    try {
      line = String.format (
          "CREATE OR REPLACE PACKAGE BODY %s AS%s", packageName, NEW_LINE);
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
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
