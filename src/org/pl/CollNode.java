package org.pl;

import org.pl.ErrorCode;
import org.pl.Array;
import org.pl.IListNode;

public class CollNode <T> extends Array <T> implements IListNode <T>{
/*
 * @ interface IListNode {
*/
	public int GetSuccessor (IListNode <T> successor) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
	public int GetPredecessor (IListNode <T> predecessor) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
/*
 * @ interface IListNode }
*/
}
