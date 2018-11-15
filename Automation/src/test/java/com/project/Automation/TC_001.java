package com.project.Automation;

import org.testng.annotations.Test;

public class TC_001 extends BaseTest
{
	
  @Test
  public void f() throws Exception 
  {
	  openBrowser("CHROME");
	  navigate("https://www.amazon.in");
	  text("twotabsearchtextbox","sony");
	  clickElement("//*[@id=\"nav-search\"]/form/div[2]/div/input");
  }








}
