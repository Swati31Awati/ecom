package com.ecom.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.base.BaseClass;

public class ExtendReport extends BaseClass{

	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentTest logger;
	
	public static void generateExtentReport() {
		
		 extentSparkReporter = new ExtentSparkReporter(projectPath+"//extentreport//testreport.html");
		 
	}
	
	public static void flushReport() {
		ExtendReport.flushReport();
	//	generateExtentReport();
	}

}


