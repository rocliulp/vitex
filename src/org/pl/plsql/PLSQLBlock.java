/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.Object;
import org.pl.ErrorCode;
import org.pl.collection.AppendableCollection;

public abstract class PLSQLBlock
extends AppendableCollection <IPLSQLStatement> implements IPLSQLBlock {
  /*
   * IPLSQLBlock
   */
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
