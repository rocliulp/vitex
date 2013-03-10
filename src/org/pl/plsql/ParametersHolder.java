/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public abstract class ParametersHolder extends PLSQLBlock {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    try {
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    String line = null;
    int ret = 0;
    Integer count = null;
    ret = GetCount (count);
    if (ret != ErrorCode.EC_OK) return ret;
    if (count > 0) {
      try {
        line = String.format ("(");
        sql.append (line);
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }

      int i = -1;
      while (++i < count) {
        Parameter param = null;
        ret = GetAt (param, i);
        if (ret != ErrorCode.EC_OK) return ret;
        StringBuffer sb = new StringBuffer ();
        ret = param.GetSQL (sb);
        if (ret != ErrorCode.EC_OK) return ret;
        try {
          if (i == count - 1) {
            line = String.format ("%s", sb.toString ());
          } else {
            line = String.format ("%s, ", sb.toString());
          }
          sql.append (line);
        } catch (Exception e) {
          return ErrorCode.EC_OUT_OF_MEMORY;
        }
      }

      try {
        line = String.format (")");
        sql.append (line);
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    }

    return ErrorCode.EC_OK;
  }
}
