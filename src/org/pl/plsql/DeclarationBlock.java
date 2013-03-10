/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class DeclarationBlock extends PLSQLBlock {
  /*
   * IPLSQLBlock
   */
  public int GetSQL (StringBuffer sql) {
    try {
      sql = new StringBuffer ();
    } catch (Exception e) {
      return ErrorCode.EC_OUT_OF_MEMORY;
    }

    Integer count = -1;
    int ret = 0;
    ret = GetCount (count);
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

    return ErrorCode.EC_OK;
  }
}
