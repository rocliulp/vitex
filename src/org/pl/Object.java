package org.pl;

public class Object extends java.lang.Object implements IObject {
  /*
   * Protected methods
   */
  protected int ErrorReturn (int ec) {
    return ec;
  }

  /*
   * Main to test this class
   */
	public static void main (String args []) {
		System.exit (ErrorCode.EC_NOT_IMPLEMENTED);
	}
}
