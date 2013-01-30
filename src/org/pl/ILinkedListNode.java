package org.pl;

public interface ILinkedListNode <T> {
	int GetPredecessor (ILinkedListNode <T> linkedListNode);
  int GetSuccessor (ILinkedListNode <T> linkedListNode);
}
