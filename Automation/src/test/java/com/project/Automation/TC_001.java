package com.project.Automation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TC_001 extends BaseTest
{
	public static final Logger log=Logger.getLogger(TC_001.class.getName());
	
	
  @Test
  public void AmazonSearch() throws Exception 
  {
	  log.info("================ Started Test TC_001 =======================");
	  
	  openBrowser("chromebrowser");
	  log.info("Selected the Browser ---" + prop.getProperty("chromebrowser"));
	  navigate("amazonurl");
	  log.info("Navigated to URL --" + prop.getProperty("amazonurl"));
	  text("amazonsearchtext_id","sony");
	  log.info("Enter Search keyword By using Locator --" + prop.getProperty("amazonsearchtext_id"));
	  clickElement("amazonsearchbutton_xpath");
	  log.info("Clicked on Search Button By using Locator --" + prop.getProperty("amazonsearchbutton_xpath"));
	  
	  log.info("================ Ended Test TC_001 =======================");
  }








}
