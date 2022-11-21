package com.ecom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	 

	static String projectPath=System.getProperty("user.dir");
	public static WebDriver driver;
	
	public static void getDriver() {
		
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"\\driver");
		 driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		

	}

}
