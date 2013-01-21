package org.pl;

public interface ICollBlock <T> {
	int GetSuccessor ( ICollBlock <T> successor);
	int GetPredecessor (ICollBlock <T> predecessor);

	int GetCapacity (Integer capacity);
	int GetSize (Integer size);
}
