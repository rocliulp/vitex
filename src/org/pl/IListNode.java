package org.pl;

public interface IListNode <T> {
	int GetSuccessor (IListNode <T> listNode);
	int GetPredecessor (IListNode <T> listNode);
}
