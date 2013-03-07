/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.Object;
import org.pl.ErrorCode;
import org.pl.collection.Collection;

public abstract class PLSQLBlock extends Collection implements IPLSQLBlock {
  public int GetBlockName () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetBlockBody () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetBlockType () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * IPLSQLStatement
   */
  public abstract int GetSQL (StringBuffer sql);
}
