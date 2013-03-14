/*
 * @author Paul
 */

package org.pl.automation.web;

import org.pl.ErrorCode;
import org.pl.Out;
import org.openqa.selenium.WebDriver;

public abstract class SeleniumDrivingPage extends Page
implements ISeleniumDrivingPage, IPageFlowStatus {
  /*
   * Private members
   */
  private WebDriver seleniumDriver = null;
  private String xPath = null;

  /*
   * Constructor
   */
  public SeleniumDrivingPage throws NullParameterException (
    String url, WebDriver driver) {
    super (url);
    if (driver == null)
      throw new NullParameterException ("SeleniumDrivingPage (~)");
    
    seleniumDriver = driver;
  }

  /*
   * ISeleniumDrivingPage
   */
  public int GetSeleniumDriver (Out <WebDriver> driver) {
    if (driver == null) return ErrorCode.EC_NULL_PARAMETER;
    if (seleniumDriver == null) return ErrorCode.EC_NULL_OBJECT;

    driver.SetParam (seleniumDriver);

    return ErrorCode.EC_OK;
  }

  public abstract int PageflowIdentify;

  /*
   * IPageFlowStatus
   */
  public int GetXPath (Out <String> path) {
    if (path == null) return ErrorCode.EC_NULL_PARAMETER;
    path.SetParam (xPath);
    return ErrorCode.EC_OK;
  }
}
