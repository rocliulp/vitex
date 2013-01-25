package org.pl;

import org.pl.ErrorCode;
import org.pl.Array;
import org.pl.ILinkedListNode;

public class CollNode <T> extends Array <T> implements ILinkedListNode <T>{
/*
 * @ interface ILinkedListNode {
*/
	public int GetPredecessor (ILinkedListNode <T> predecessor) {
		// TODO:
		return ErrorCode.EC_NOT_IMPLEMENTED;
	}
/*
 * @ interface ILinkedListNode }
*/
}
