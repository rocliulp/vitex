/*
 * @author Paul
 */
package org.pl.automation.web;

import org.openqa.selenium.WebDriver;

public interface ISeleniumDrivingPage {
  int GetSeleniumDriver (Out <WebDriver> driver);
  int PageFlowIdentify (String path, WebDriver driver);
}
