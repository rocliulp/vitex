/*
 * @author Paul
 */

package org.pl.plsql;

public interface IProcedureStatement {
  int GetProcedureName (StringBuffer name);
  int GetProcedureParameters ();
}
