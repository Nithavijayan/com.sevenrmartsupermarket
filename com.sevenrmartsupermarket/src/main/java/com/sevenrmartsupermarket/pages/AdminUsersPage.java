package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	PageUtility pageutility = new PageUtility(driver);

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "(//div[@class='col-sm-12']//a)[1]")
	private WebElement newButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//thead//tr//th")
	private List<WebElement> tableHeader;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement userNameSearchField;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement userTypeSearchDropDown;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement adminSearchButton;
	@FindBy(xpath = "//div[@class='col-sm-6']//h1")
	private WebElement adminUsersHeader;
	

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getColorOfNewButton() {

		return generalutility.getCssValueOfElement(newButton, "color");
	}

	public String getTextOfSearchButton() {
		return searchButton.getText();
	}


	public void enterAdminUserName(String userName) {
		userNameField.sendKeys(userName);
	
	}

	public void enterAdminPassword(String password) {
		passwordField.sendKeys(password);
	
	}

	public void selectAdminUserType() {
		pageutility.selectByIndex(userTypeDropDown, 2);

	}

	public String enterNewAdminUser(String userName, String password) {
		newButton.click();
		enterAdminUserName(userName);
		enterAdminPassword(password);
		selectAdminUserType();
		saveButton.click();
		return adminUsersHeader.getText();
	}

	public List<String> getHeaderOfTable() {
		List<String> header = new ArrayList<String>();
		header = generalutility.getTextOf_Elements(tableHeader);
		return header;
	}

	public AdminUsersPage enterUserName(String userName) {
		userNameSearchField.sendKeys(userName);
		return this;
	}

	public AdminUsersPage enterUserTypeDropDown(int index) {
		pageutility.selectByIndex(userTypeSearchDropDown, index);
		return this;
	}

	public AdminUsersPage clickOnSearchButton() {
		adminSearchButton.click();
		return this;
	}

	

	public AdminUsersPage searchAdminUser(String userName, int index) {
		searchButton.click();
		return this.enterUserName(userName).enterUserTypeDropDown(index).clickOnSearchButton();
		

	}

}
