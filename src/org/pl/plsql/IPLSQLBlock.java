/*
 * @author Paul
 */

package org.pl.plsql;

public interface IPLSQLBlock extends IPLSQLStatement{
  int GetBlockName ();
  int GetBlockBody ();
  int GetBlockType ();
}
