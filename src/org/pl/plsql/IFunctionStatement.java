/*
 * @author Paul
 */

package org.pl.plsql;

public interface IFunctionStatement {
  int GetFunctionName (StringBuffer name);
  int GetFunctionParameters ();
  int GetFunctionReturn (FunctionReturnDeclaration retDec);
}
