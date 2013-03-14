/*
 * @author Paul
 */

package org.pl.automation.web;

import org.pl.Out;

public interface IPage {
  int GetPageURL(Out <String> url);
  int OverflowIdentify (Out <Page> next);
}
