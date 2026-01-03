package dataproviderclasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utility.ExcelDataUtility;

public class DataProviderClass {

	static String loginFilePath = "D:\\eclipse-workspace\\parabank-selenium-automation\\src\\test\\resources\\testdatas\\parabanktestdata.xlsx";

	@DataProvider(name = "registerData")
	public static Object[][] registerData() throws IOException {

		System.out.println("  ");
		return ExcelDataUtility.readExceldata(loginFilePath);
		

	}


	@DataProvider(name = "logindata")
	public static Object[][] loginData() throws IOException {

		System.out.println("  ");
		return ExcelDataUtility.readExceldata(loginFilePath);
		

	}


}
