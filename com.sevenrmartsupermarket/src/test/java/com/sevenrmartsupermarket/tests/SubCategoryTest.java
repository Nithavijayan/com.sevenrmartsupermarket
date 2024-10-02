package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class SubCategoryTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;

	@Test(groups={"sanity","regression"})
	public void verifyTitleOfNewSubCategory() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		subcategorypage = homepage.clickOnSubCategoryMoreInfo();
		String title=subcategorypage.getTitleOfSubCategoryPage();
		String category = GeneralUtility.getRandomName();
		subcategorypage.enterNewSubCategory(category,6);
		Assert.assertEquals( title, "List Sub Categories | 7rmart supermarket");
	}
	@Test(groups = "sanity")
	public void verifyHeaderOfSubCategorySearch()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickOnSubCategoryMoreInfo();
		subcategorypage.getSubCategorySearch("Fridge",7);
		String header=subcategorypage.getSubcategorySearchHeader();
		Assert.assertEquals( header,"Search List Sub Categories");
	}
	@Test(groups = "smoke")
	public void verifyAlertMessageWhileDeletion()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage=homepage.clickOnSubCategoryMoreInfo();
		String alert=subcategorypage.getDeleteAlertMessage();
		Assert.assertEquals(alert, "Do you want to delete this Sub Category?");
	}

}
