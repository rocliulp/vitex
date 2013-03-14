/*
 * @author Paul
 */

package org.pl.automation.web;

import org.pl.Out;

public interface IPageFlowStatus implements IPage {
  int GetXPath (Out <String> path);
}
