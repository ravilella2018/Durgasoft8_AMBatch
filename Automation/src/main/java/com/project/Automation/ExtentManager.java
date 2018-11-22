package com.project.Automation;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent == null)
		{
			Date dt=new Date();
			String fileName = dt.toString().replace(":", "_").replace(" ", "_")+".html";
			extent=new ExtentReports("D:\\report\\"+fileName);
			//extent=new ExtentReports("D://extentreport.html");
			
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportConfig.xmls"));
			extent.addSystemInfo("Selenium Version", "3.8.1").addSystemInfo("Environment","QA" );
		}
		return extent;
	}
}
