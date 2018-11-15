package com.project.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class BaseTest 
{
	public static WebDriver driver;
	public static String path="./config.properties";
	
	
	public static String loadData(String key) throws Exception
	{
		Properties p=new Properties();
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		p.load(fis);
		return p.getProperty(key);
	}
	
	public void openBrowser(String browser) throws Exception 
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,loadData("chromedriver_exe") );
			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("FF"))
		{
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe" );
			System.setProperty("webdriver.gecko.driver",loadData("firefoxdriver_exe"));
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			//System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//drivers//IEDriverServer.exe" );
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,loadData("iedriver_exe"));
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("EDGE"))
		{
			//System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe" );
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY,loadData("edgedriver_exe"));
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
	}
	
	
	public void navigate(String url) 
	{
		driver.get(url);
	}
	
	
	public void text(String eleLocator_id, String value) 
	{
		driver.findElement(By.id(eleLocator_id)).sendKeys(value);
	}
	
	public void clickElement(String eleLocator_xpath) 
	{
		driver.findElement(By.xpath(eleLocator_xpath)).click();
	}
}
