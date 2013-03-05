/*
 * @author Paul
 */

package org.pl;

public abstract class ID extends Object implements IData, IComparable {
  /*
   * IID
   */
  public abstract int ToString (java.lang.String id);

  /*
   * IComparable
   */
  public abstract int GreaterThan (boolean result, IComparable obj);
  public abstract int SmallerThan (boolean result, IComparable obj);
  public abstract int GreaterEqual (boolean result, IComparable obj);
  public abstract int SmallerEqual (boolean result, IComparable obj);

  /*
   * IEquable
   */
  public abstract int Equals (boolean result, IEquable obj);
  public abstract int NotEquals (boolean result, IEquable obj);
}
