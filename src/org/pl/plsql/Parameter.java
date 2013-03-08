/*
 * @author Paul
 */

package org.pl.plsql;

import org.pl.exception.NullParameterException;

public class Parameter extends Variable implements IParameter {
  /*
   * Constructor 
   */
  public Parameter (String name, String type) throws NullParameterException {
    super (name, type);
  }

  /*
   * IParameter
   */
  public int GetParameterName (StringBuffer name) {
    return GetVariableName (name);
  }

  public int GetParameterType (StringBuffer type) {
    return GetVariableType (type);
  }
}
