/*
 * @author Paul
 */

package org.pl;

public abstract class ID extends Object implements IData {
  /*
   * IID
   */
  public abstract int ToString (java.lang.String id);

  /*
   * IComparable
   */
  public abstract int GreaterThan (Boolean result, IComparable obj);
  public abstract int SmallerThan (Boolean result, IComparable obj);
  public abstract int GreaterEqual (Boolean result, IComparable obj);
  public abstract int SmallerEqual (Boolean result, IComparable obj);

  /*
   * IEquable
   */
  public abstract int Equals (Boolean result, IEquable obj);
  public abstract int NotEquals (Boolean result, IEquable obj);
}
