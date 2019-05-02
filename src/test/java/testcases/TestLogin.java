package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TestLogin extends TestBase{

	@Test
	public void testLogin() {
		
		log.debug("enter testLogin to test.");
		
		sendKeys("usn_XPATH", "gotIt");
		sendKeys("psw_CSS", "gotIt123");
		click("sbm_NAME");
		
		By jumpLocator = By.partialLinkText("请点击这里");
		driver.findElement(jumpLocator).click();
		
		By inElement = By.linkText("我的空间");
		Assert.assertTrue(isElementPresent(inElement), "target element not found in page source.");
	
		log.debug("inside testLogin test is over.");
	}
}
