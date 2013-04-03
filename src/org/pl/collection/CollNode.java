package org.pl.collection;

import org.pl.ErrorCode;
import org.pl.Array;
import org.pl.ILinkedListNode;
import org.pl.exception.OutOfRangeException;

public class CollNode <T>
extends Array <T> implements ILinkedListNode <CollNode <T>> {
  /*
   * Private members
   */
  private CollNode <T> predecessor = null;
  private CollNode <T> successor = null;

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
  public int GetPredecessor (CollNode <T> predecessor) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }

  public int GetSuccessor (CollNode <T> successor) {
    // TODO:
    return ErrorCode.EC_NOT_IMPLEMENTED;
  }
}
