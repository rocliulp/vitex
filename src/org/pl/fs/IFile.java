/*
 * @author Paul
 */

package org.pl.fs;

import org.pl.String;

public interface IFile {
  int GetFileName (String fileName);
  int GetFullFileName (String fullName);
  int Load ();
}
