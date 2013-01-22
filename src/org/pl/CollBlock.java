package org.pl;

import org.pl.ErrorCode;
import org.pl.Object;

public class CollBlock <T> extends Object implements ICollBlock <T>{
/*
 * @ interface ICollBlock {
*/
	public int GetSuccessor (ICollBlock <T> successor) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
	public int GetPredecessor (ICollBlock <T> predecessor) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}

	public int GetCapacity (Integer capacity) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
	public int GetSize (Integer size) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
/*
 * @ interface ICollBlock }
*/
}
