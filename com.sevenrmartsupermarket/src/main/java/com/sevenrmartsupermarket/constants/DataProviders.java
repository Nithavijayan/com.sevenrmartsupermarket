package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {
	
	ExcelReader excelreader=new ExcelReader();
	
	@DataProvider(name="adminLogin")
	
	public Object[][] enterAdminLoginWithMultipleData()
	{
		excelreader.setExcelFile("Login", "Login Credentials");
		return excelreader.getMultidimentionalData(2, 2);
	}
	@DataProvider(name = "enterNewAdminUser")
	public Object[][] enterNewAdminUserWithMultipleData()
	{
		excelreader.setExcelFile("AdminUsers","NewAdminUsers");
		return excelreader.getMultidimentionalData(3, 2);
	}


}
