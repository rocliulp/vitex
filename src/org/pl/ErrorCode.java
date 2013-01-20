package org.pl;

public class ErrorCode {
	private ErrorCode () throws CanNotInstantiateStaticClassException {
		throw new CanNotInstantiateStaticClassException ();
	}

	public static int EC_OK = 0;
	public static int EC_NOT_IMPLEMENTED;
	public static int EC_NULL_PARAMETER;
	public static int EC_OUT_OF_RANGE;
	public static int EC_OUT_OF_MEMORY;
}
