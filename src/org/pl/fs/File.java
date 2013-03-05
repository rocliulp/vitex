/*
 * @author Paul
 */
package org.pl.fs;

import org.pl.Object;
import org.pl.ErrorCode;
import org.pl.collection.BinSearchCollection;

public abstract class File extends BinSearchCollection implements IFile {
  /*
   * Private members
   */
  private String fullFileName = null;

  /*
   * IFile
   */
  public int GetFileName (String fileName) {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetFullFileName (String fullFileName) {
    if (this.fullFileName == null) return ErrorCode.EC_NULL_OBJECT;
    fullFileName = this.fullFileName;
    return ErrorCode.EC_OK;    
  }

  public int Load () {
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
