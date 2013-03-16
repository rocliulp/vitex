/*
 * @author Paul
 */

package org.pl.automation.web;

import org.pl.Object;
import org.pl.Out;
import org.pl.global.Global;
import org.pl.ErrorCode;
import org.pl.exception.NullParameterException;

public abstract class Page extends Object implements IPage {
  /*
   * Private members
   */
  /*
   * Constructor
   */

  /*
   * IPage
   */
  public abstract int WaitForReady (int timeout, int sleep);
}
