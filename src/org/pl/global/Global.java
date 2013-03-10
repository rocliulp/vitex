/*
 * @author Paul
 */

package org.pl.global;

public class Global {
  public static boolean IsStringNullOrEmpty (String str) {
    if (str == null) return true;
    if (str == "") return true;
    return false;
  }
}
