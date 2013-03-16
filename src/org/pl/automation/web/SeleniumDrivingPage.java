/*
 * @author Paul
 */

package org.pl.automation.web;

import org.pl.ErrorCode;
import org.pl.Out;
import org.pl.exception.NullParameterException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class SeleniumDrivingPage extends Page
implements ISeleniumDrivingPage {
  /*
   * Private members
   */
  private WebDriver seleniumDriver = null;

  /*
   * Constructor
   */
  public SeleniumDrivingPage (WebDriver driver)
		throws NullParameterException {
    if (driver == null)
      throw new NullParameterException ("SeleniumDrivingPage (~)");
    
    seleniumDriver = driver;
  }

  /*
   * IPage
   */
  public abstract int WaitForReady (int timeout, int sleep);

  /*
   * ISeleniumDrivingPage
   */
  public int GetSeleniumDriver (Out <WebDriver> driver) {
    if (driver == null) return ErrorCode.EC_NULL_PARAMETER;
    if (seleniumDriver == null) return ErrorCode.EC_NULL_OBJECT;

    driver.SetParam (seleniumDriver);

    return ErrorCode.EC_OK;
  }
}
