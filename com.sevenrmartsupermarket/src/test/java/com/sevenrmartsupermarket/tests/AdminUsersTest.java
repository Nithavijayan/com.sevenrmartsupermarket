package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;


public class AdminUsersTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;

	@Test(groups = "smoke")
	public void verifyColorOfNewButton() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		String color = adminuserspage.getColorOfNewButton();
		Assert.assertEquals(color,"rgba(255, 255, 255, 1)");
	}

	@Test(groups={"smoke","regression"}, dataProvider = "enterNewAdminUser", dataProviderClass = DataProviders.class)
	public void verifyNewAdminUser(String userName, String password) {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		String newUser = GeneralUtility.getRandomName();
		String newAdminheader = adminuserspage.enterNewAdminUser(newUser, password);
		Assert.assertEquals(newAdminheader,"Admin Users");

	}

	@Test(groups = "smoke")
	public void verifyTextOfSearchButton() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		String text = adminuserspage.getTextOfSearchButton();
		Assert.assertEquals(text,"Search");
	}

	@Test(groups={"sanity","regression"})
	public void verifyHeaderOfTable() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		List<String> headerList = adminuserspage.getHeaderOfTable();
		List<String> expectedHeader = new ArrayList<String>();
		expectedHeader.add("Username");
		expectedHeader.add("Usertype");
		expectedHeader.add("Status");
		expectedHeader.add("Password");
		expectedHeader.add("Action");
		Assert.assertEquals(headerList,expectedHeader);
	}

	@Test(groups = "sanity")
	public void verifyAdminSearch() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		adminuserspage.searchAdminUser("Rhona",2);
		Assert.assertEquals(adminuserspage.getTextOfSearchButton() ,"Search");

	}
}
