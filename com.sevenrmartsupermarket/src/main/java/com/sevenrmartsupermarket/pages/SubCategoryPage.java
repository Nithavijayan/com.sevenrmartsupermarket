package com.sevenrmartsupermarket.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {

	WebDriver driver;
	PageUtility pageutility;
	WaitUtility wait;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categorySelectDropDown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement categorySearchDropDown;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement subcategorySearchField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement subCategorySearchButton;
	@FindBy(xpath = "(//div[@class='card-header'])[1]")
	private WebElement subCategorySearchHeader;
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	private WebElement deleteButton;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitleOfSubCategoryPage() {
		return driver.getTitle();
	}

	public void enterNewSubCategory(String subcategory, int index) {
		pageutility = new PageUtility(driver);
		newButton.click();
		pageutility.selectByIndex(categorySelectDropDown, index);
		subCategoryField.sendKeys(subcategory);
		String filepath = Constants.IMAGE_FILE_PATH;
		chooseFileButton.sendKeys(filepath);
		pageutility.scrollAndClick(saveButton);

	}

	public String getSubcategorySearchHeader() {
		return subCategorySearchHeader.getText();
	}

	public void getSubCategorySearch(String subCategory, int index) {
		pageutility = new PageUtility(driver);
		searchButton.click();
		pageutility.selectByIndex(categorySearchDropDown, index);
		subcategorySearchField.sendKeys(subCategory);
		pageutility.scrollAndClick(subCategorySearchButton);

	}
	public String getDeleteAlertMessage()
	{
		pageutility = new PageUtility(driver);
		wait=new WaitUtility();
		wait.waitForClickable(driver, deleteButton, 10);
		deleteButton.click();
		String message= pageutility.alertGetText();
		pageutility.alertAccept();
		return message;
	}

}
