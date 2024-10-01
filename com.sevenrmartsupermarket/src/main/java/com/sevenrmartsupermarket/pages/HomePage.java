package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {

	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();

	@FindBy(xpath = "//div[@class='inner']//p")
	List<WebElement> homePageCards;
	@FindBy(xpath = "//div[@class='info']//a")
	private WebElement profileName;
	@FindBy(xpath = "(//div[@class='inner'])[1]//following-sibling::a")
	private WebElement adminCardMoreInfo;
	@FindBy(xpath = "(//div[@class='inner'])[3]//following-sibling::a")
	private WebElement categoryCardMoreInfo;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement websiteName;
	@FindBy(xpath = "(//div[@class='icon'])[4]//following-sibling::a")
	private WebElement subCategoryCardMoreInfo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return generalutility.getTextOfElement(profileName);
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public String getTextOfWebsiteName() {
		return generalutility.getTextOfElement(websiteName);
	}

	public String getSizeOfWebsiteName() {
		return generalutility.getCssValueOfElement(websiteName, "font-size");
	}

	public String getStyleOfWebsiteName() {
		return generalutility.getCssValueOfElement(websiteName, "font-style");
	}

	public List<String> getAllCardNames() {
		List<String> cardnames = generalutility.getTextOf_Elements(homePageCards);
		return cardnames;
	}

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminCardMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public CategoryPage clickOnCategoryMoreInfo() {
		categoryCardMoreInfo.click();
		return new CategoryPage(driver);
	}

	public SubCategoryPage clickOnSubCategoryMoreInfo() {
		subCategoryCardMoreInfo.click();
		return new SubCategoryPage(driver);

	}

}
