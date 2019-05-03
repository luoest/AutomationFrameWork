package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class TestLogin extends TestBase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void testLogin(Hashtable<String, String> data) {
		
		if (!TestUtil.isTestRunnable("TestLogin", excel)) {
			throw new SkipException("SKIP ====>>" + "TestLogin".toUpperCase());
		}
		
		log.debug("enter testLogin to test.");
		Reporter.log("enter testLogin to test.");
		Reporter.log("<br>");
		
		sendKeys("usn_XPATH", data.get("username"));
		sendKeys("psw_CSS", data.get("password"));
		click("sbm_NAME");
		
		By jumpLocator = By.partialLinkText(data.get("jump"));
		driver.findElement(jumpLocator).click();
		
		By inElement = By.linkText(data.get("inele"));
		Assert.assertTrue(isElementPresent(inElement), "target element not found in page source.");
//		By inElement2 = By.linkText("»ðÐÇÈËµÄµØÅÌ");
//		Assert.assertTrue(isElementPresent(inElement2), "target element not found in page source.");
		
		log.debug("inside testLogin test is over.");
		Reporter.log("inside testLogin test is over.");
		Reporter.log("<br>");
	}
}
