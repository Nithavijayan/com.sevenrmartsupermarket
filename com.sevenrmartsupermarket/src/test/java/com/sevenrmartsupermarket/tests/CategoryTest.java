package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class CategoryTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;

	@Test(groups = "smoke")
	public void verifyListCategorySearch() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		categorypage = homepage.clickOnCategoryMoreInfo();
		categorypage.searchCategory("Seasonal Gifts");
		String title = categorypage.getTitleOfCategoryPage();
		Assert.assertEquals(title,"List Categories | 7rmart supermarket");
	}

	@Test(groups={"sanity","regression"})
	public void verifyEditCategoryAlertMessage() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		categorypage = homepage.clickOnCategoryMoreInfo();
		String alert = categorypage.editCategoryData("burger");
		Assert.assertEquals(alert, "Alert!");
	}

	@Test(groups = "smoke")
	public void verifyColorOfResetButton() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		categorypage = homepage.clickOnCategoryMoreInfo();
		String color = categorypage.getColorOfResetButton();
		Assert.assertEquals( color, "rgba(31, 45, 61, 1)");
	}

}
