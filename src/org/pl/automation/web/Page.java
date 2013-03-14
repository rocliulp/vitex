/*
 * @author Paul
 */

package org.pl.automation.web.Page;

import org.pl.Object;
import org.pl.Out;
import org.pl.exception.NullParameterException;

public abstract class Page extends Object implements IPage {
  /*
   * Private members
   */
  private pageURL = null;
  
  /*
   * Constructor
   */
  public Page (String url) throws NullParameterException {
    if (Global.IsStringNullOrEmtpy (url))
      throw new NullParameterException ("Page (~)");

    pageURL = rul;
  }

  /*
   * IPage
   */
  public int GetPageURL (Out <String> url) {
    if (url == null) return ErrorCode.EC_NULL_PARAMETER;
    if (pageURL == null) return ErrorCode.EC_NULL_OBJECT;

    url.SetParam (pageURL);

    return ErrorCode.EC_OK;
  }
}
