package org.pl;

import org.pl.exception.CanNotInstantiateStaticClassException;

public class ErrorCode extends Object {
	private ErrorCode () throws CanNotInstantiateStaticClassException {
		throw new CanNotInstantiateStaticClassException ();
	}

	public static int EC_OK = 0;
	public static int EC_NOT_IMPLEMENTED = 1;
	public static int EC_NULL_PARAMETER = 2;
	public static int EC_OUT_OF_RANGE = 3;
	public static int EC_OUT_OF_MEMORY = 4;
  public static int EC_IMPOSSIBLE_CASE = 5;

	public static void main (String args []) {
		try {
			ErrorCode ec = new ErrorCode ();
			System.out.println ("Error happened while instantiating ErrorCode.");
		} catch (CanNotInstantiateStaticClassException e) {
			System.out.println ("Prevented instantiation.");
		} finally {
		}
		
		System.out.println ("EC_OK: " + EC_OK);
		System.out.println ("EC_NOT_IMPLEMENTED: " + EC_NOT_IMPLEMENTED);
		System.out.println ("EC_NULL_PARAMETER: " + EC_NULL_PARAMETER);
		System.out.println ("EC_OUT_OF_RANGE: " + EC_OUT_OF_RANGE);
		System.out.println ("EC_OUT_OF_MEMORY: " + EC_OUT_OF_RANGE);
    System.out.println ("EC_IMPOSSIBLE_CASE: " + EC_IMPOSSIBLE_CASE);

		System.exit (EC_OK);
	}
}
