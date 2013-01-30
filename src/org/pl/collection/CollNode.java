package org.pl.collection;

import org.pl.ErrorCode;
import org.pl.Array;
import org.pl.ILinkedListNode;
import org.pl.exception.OutOfRangeException;

public class CollNode <T> extends Array <T> implements ILinkedListNode <T>{
  /*
   * @ Constructor
   */
  @SuppressWarnings ({"unchecked"})
  public CollNode (int capacity) throws OutOfRangeException {
    super (capacity);
  }

  /*
   * @ interface ILinkedListNode
  */
  public int GetPredecessor (ILinkedListNode <T> predecessor) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetSuccessor (ILinkedListNode <T> successor) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
