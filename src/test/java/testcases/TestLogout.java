package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class TestLogout extends TestBase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void testLogout(Hashtable<String, String> data) {
		
		if (!TestUtil.isTestRunnable("TestLogout", excel)) {
			throw new SkipException("SKIP ====>>" + "testLogout".toUpperCase());
		}
		
		log.debug("enter testLogout to test.");
		Reporter.log("enter testLogout to test.");
		Reporter.log("<br>");
		
		click("out_XPATH");
		
		ExpectedConditions.alertIsPresent();
		String alertInfo = driver.switchTo().alert().getText();
		log.debug("alertInfo: " + alertInfo);
		Reporter.log("alertInfo: " + alertInfo);
		Reporter.log("<br>");
		System.out.println(alertInfo);
		
		Assert.assertEquals(alertInfo, data.get("alertText"));
		driver.switchTo().alert().accept();
		
		driver.findElement(By.partialLinkText(data.get("jump"))).click();
		
		log.debug("inside testLogout test is over.");
		Reporter.log("inside testLogout test is over.");
		Reporter.log("<br>");

	}
}
