package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getCssValueOfElement(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
	}

	public List<String> getTextOf_Elements(List<WebElement> elementList) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elementList) {
			data.add(element.getText());
		}
		return data;
	}
	public boolean elementIsEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	public boolean elementIsDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public boolean elementIsSelected(WebElement element)
	{
		return element.isSelected();
	}
	public static String getRandomName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
}
