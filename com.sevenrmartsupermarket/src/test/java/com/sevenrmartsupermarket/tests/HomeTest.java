package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class HomeTest extends Base {

	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test(groups = "smoke")
	public void verifyProfileName() {

		loginPage = new LoginPage(driver);
		homepage = loginPage.login("Akhil", "User123");
		String profileName = homepage.getProfileName();
		Assert.assertEquals(profileName,"Akhil");
	}

	@Test(groups = "smoke", retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyStyleOfwebsiteName() {

		loginPage = new LoginPage(driver);
		homepage = loginPage.login("Akhil", "User123");
		String style = homepage.getStyleOfWebsiteName();
		Assert.assertEquals( style,"normal");
	}

	@Test(groups = "sanity")
	public void verifyAllCardNames() {

		loginPage = new LoginPage(driver);
		homepage = loginPage.login();
		List<String> cardNames = homepage.getAllCardNames();
		List<String> expectedCardNames = new ArrayList<String>();
		expectedCardNames.add("Admin Users");
		expectedCardNames.add("Dashboard");
		expectedCardNames.add("Category");
		expectedCardNames.add("Sub Category");
		expectedCardNames.add("Manage Contact");
		expectedCardNames.add("Manage Gift cards &vouchers");
		expectedCardNames.add("Test name");
		expectedCardNames.add("Manage Product");
		expectedCardNames.add("Manage News");
		expectedCardNames.add("Manage Footer Text");
		expectedCardNames.add("Manage Category");
		Assert.assertEquals(cardNames,expectedCardNames);
	}

	@Test(groups = "smoke")
	public void verifyAdminUsersCard() {

		loginPage = new LoginPage(driver);
		homepage = loginPage.login("Akhil", "User123");
		homepage.clickOnAdminUsersMoreInfo();
		String title = homepage.getTitleOfPage();
		Assert.assertEquals( title,"Admin Users | 7rmart supermarket");
	}

	@Test(groups = "smoke")
	public void verifyWebsiteNameOfCategoryCard() {

		loginPage = new LoginPage(driver);
		homepage = loginPage.login();
		homepage.clickOnCategoryMoreInfo();
		String name = homepage.getTextOfWebsiteName();
		Assert.assertEquals(name,"7rmart supermarket");
	}

	@Test(groups = "smoke")
	public void verifyTitleOfSubCategoryCard() {
		loginPage = new LoginPage(driver);
		homepage = loginPage.login();
		homepage.clickOnSubCategoryMoreInfo();
		String title = homepage.getTitleOfPage();
		Assert.assertEquals(title,"List Sub Categories | 7rmart supermarket");
	}

}
