package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups="smoke")
	public void verifyAdminLogin() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login("Akhil", "User123");
		String expectedProfileName = "Akhil";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName,expectedProfileName);

	}

	@Test(groups = "smoke",dataProvider = "adminLogin", dataProviderClass = DataProviders.class)
	public void verifyLoginWithMutipleUsers(String userName, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login(userName, password);
		String title = loginpage.getTitleOfLoginPage();
		Assert.assertEquals(title,"Dashboard | 7rmart supermarket");
	}

}
