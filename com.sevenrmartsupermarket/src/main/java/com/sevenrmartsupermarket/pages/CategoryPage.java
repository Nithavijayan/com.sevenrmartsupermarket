package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class CategoryPage {

	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility = new WaitUtility();

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement categorySearchButton;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetButton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[2]")
	private WebElement editButton;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement editCategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement editCategoryChooseFileButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement updateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	private WebElement alertMessage;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchCategory(String category) {
		searchButton.click();
		categoryField.sendKeys(category);
		categorySearchButton.click();
	}

	public String editCategoryData(String category) {
		pageutility = new PageUtility(driver);
		editButton.click();
		editCategoryfield.clear();
		editCategoryfield.sendKeys(category);
		String filePath = Constants.EDIT_IMAGE_FILE_PATH;
		editCategoryChooseFileButton.sendKeys(filePath);
		pageutility.scrollAndClick(updateButton);
		return alertMessage.getText();

	}

	public String getTitleOfCategoryPage() {
		return driver.getTitle();
		
	}

	public String getColorOfResetButton() {
		return resetButton.getCssValue("color");
		
	}
	

}
