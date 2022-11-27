package com.ecom.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.base.BaseClass;
import com.ecom.pom.AddCustomerPom;
import com.ecom.pom.LoginPagePom;
import com.ecom.pom.ManagerHomePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;

public class AddCustomerTest extends BaseClass {
	
	LoginPagePom loginPagePom;
	AddCustomerPom addCustomerPom;
	ExcelReader excelReader;
	Utility utility;
	ManagerHomePom managerHomePom;
	
	@BeforeClass
	public void setUp() {
		initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void setLoginCredential() throws EncryptedDocumentException, IOException {
		SoftAssert softAssert = new SoftAssert();
		excelReader = new ExcelReader();
		Sheet sh = excelReader.getSheet("Git_Login");
		Map<String, Object> data = excelReader.getData(sh);
		
		loginPagePom= new LoginPagePom();
		loginPagePom.setLoginCredentials(data.get("userid"), data.get("password"));
		softAssert.assertEquals(data.get("userid").toString(), "mngr456954");
		loginPagePom.clickOnLogin();
		
		softAssert.assertAll();

		managerHomePom=new ManagerHomePom();
		managerHomePom.clickOnNewCustomer();
		excelReader.closeResource();
		excelReader=new ExcelReader();
		
		Sheet sh1 = excelReader.getSheet("newCustomer");
		Map<String, Object> data1 = excelReader.getData(sh);
		
		AddCustomerPom addCustomerPom=new AddCustomerPom();
		addCustomerPom.setLoginCredential1(data.get("CustomerName"),data.get("Address"));
		softAssert.assertEquals(data.get("CustomerName").toString(),"abcd");
		
		managerHomePom=addCustomerPom.clickOnSubmit();
		softAssert.assertAll();
		
	
	}
	
	@Test(priority = 1)
	public void testClickOnNewCustomer() {
		Utility.applyImplicitWait();
		managerHomePom.clickOnNewCustomer();
	}

}



