package org.pl;

public interface ILinkedListNode <T> {
	int GetPredecessor (Out <ILinkedListNode <T>> outPredecessor);
  int GetSuccessor (Out <ILinkedListNode <T>> outSuccessor);
}
