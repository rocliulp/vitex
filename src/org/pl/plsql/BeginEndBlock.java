/*
 * @author Paul
 */

package org.pl.plsql;
import org.pl.ErrorCode;

public class BeginEndBlock extends PLSQLBlock {
  /*
   * IPLSQLStatement
   */
  public int GetSQL (StringBuffer sql) {
    String NEW_LINE = null;
    try {
      NEW_LINE = System.getProperty ("line.separator");
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    String line = null;
    try {
      line = String.format ("BEGIN%s", NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    Integer count = -1;
    int ret = GetCount (count);
    int i = -1;
    while (++i < count) {
      IPLSQLStatement stm = null;
      ret = GetAt (stm, i);
      if (ret != ErrorCode.EC_OK) return ret;
      StringBuffer sb = null;
      ret = stm.GetSQL (sb);
      if (ret != ErrorCode.EC_OK) return ret;
      try {
        sql.append (sb);
      } catch (Exception e) {
        return ErrorCode.EC_OUT_OF_MEMORY;
      }
    }

    try {
      line = String.format ("END;%s", NEW_LINE);
      sql.append (line);
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    return ErrorCode.EC_OK;
  }
}
