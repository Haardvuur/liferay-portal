/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.permissions.imagegallery.portlet;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DefinePortletRoleTest extends BaseTestCase {
	public void testDefinePortletRole() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Permissions Test Page",
			RuntimeVariables.replace("Media Gallery Permissions Test Page"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Options"),
			selenium.getText("//span[@title='Options']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Options']/ul/li/strong/a",
			RuntimeVariables.replace("Options"));
		selenium.waitForVisible(
			"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a");
		assertEquals(RuntimeVariables.replace("Configuration"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Configuration')]/a",
			RuntimeVariables.replace("Configuration"));
		selenium.waitForVisible(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.selectFrame(
			"//iframe[contains(@id,'configurationIframeDialog')]");
		selenium.waitForElementPresent(
			"//script[contains(@src,'/liferay/navigation_interaction.js')]");
		selenium.waitForVisible(
			"//ul[contains(@class,'tabview-list')]/li[contains(.,'Permissions')]/span/a");
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText(
				"//ul[contains(@class,'tabview-list')]/li[contains(.,'Permissions')]/span/a"));
		selenium.clickAt("//ul[contains(@class,'tabview-list')]/li[contains(.,'Permissions')]/span/a",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForVisible("//input[@id='portlet_ACTION_VIEW']");
		assertFalse(selenium.isChecked("//input[@id='portlet_ACTION_VIEW']"));
		selenium.clickAt("//input[@id='portlet_ACTION_VIEW']",
			RuntimeVariables.replace("Portlet View"));
		assertTrue(selenium.isChecked("//input[@id='portlet_ACTION_VIEW']"));
		assertFalse(selenium.isChecked(
				"//input[@id='portlet_ACTION_CONFIGURATION']"));
		selenium.clickAt("//input[@id='portlet_ACTION_CONFIGURATION']",
			RuntimeVariables.replace("Portlet Configuration"));
		assertTrue(selenium.isChecked(
				"//input[@id='portlet_ACTION_CONFIGURATION']"));
		assertFalse(selenium.isChecked(
				"//input[@id='portlet_ACTION_PERMISSIONS']"));
		selenium.clickAt("//input[@id='portlet_ACTION_PERMISSIONS']",
			RuntimeVariables.replace("Portlet Permissions"));
		assertTrue(selenium.isChecked(
				"//input[@id='portlet_ACTION_PERMISSIONS']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isChecked("//input[@id='portlet_ACTION_VIEW']"));
		assertTrue(selenium.isChecked(
				"//input[@id='portlet_ACTION_CONFIGURATION']"));
		assertTrue(selenium.isChecked(
				"//input[@id='portlet_ACTION_PERMISSIONS']"));
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Media Gallery Permissions Test Page",
			RuntimeVariables.replace("Media Gallery Permissions Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Permissions"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li[contains(.,'Permissions')]/a"));
		selenium.clickAt("//div[@class='lfr-component lfr-menu-list lfr-menu-expanded align-right null']/ul/li[contains(.,'Permissions')]/a",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isChecked(
				"//input[@id='portlet_ACTION_ADD_DOCUMENT']"));
		selenium.clickAt("//input[@id='portlet_ACTION_ADD_DOCUMENT']",
			RuntimeVariables.replace("Portlet Add Document"));
		assertTrue(selenium.isChecked(
				"//input[@id='portlet_ACTION_ADD_DOCUMENT']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isChecked(
				"//input[@id='portlet_ACTION_ADD_DOCUMENT']"));
	}
}