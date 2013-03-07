/*
 * @author Paul
 */

package org.pl.plsql;

public interface IPLSQLBlock extends IPLSQLStatement{
  int GetBlockBody ();
  int GetBlockType ();
}
