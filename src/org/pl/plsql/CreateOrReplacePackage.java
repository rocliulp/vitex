/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.ErrorCode;

public class CreateOrReplacePackage
extends PLSQLBlock implements ICreateOrReplacePackage {
  /*
   * IPLSQLBlock
   */
  public int GetSQL (StringBuffer sql) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  /*
   * ICreateOrReplacePackage
   */
  public int GetPackageName (StringBuffer name) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
