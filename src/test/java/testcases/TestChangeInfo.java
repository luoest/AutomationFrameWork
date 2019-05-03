package testcases;

import java.util.Hashtable;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class TestChangeInfo extends TestBase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void testChangeInfo(Hashtable<String, String> data) {
		
		if (!TestUtil.isTestRunnable("testChangeInfo", excel)) {
			throw new SkipException("SKIP ====>>" + "testChangeInfo".toUpperCase());
		}
		
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skip this case for the mode is not Y");
		}
		
		log.debug("enter testChangeInfo to test.");
		Reporter.log("enter testChangeInfo to test.");
		Reporter.log("<br>");
		
		clear("name_NAME");
		sendKeys("name_NAME", data.get("name"));
		
		clear("qq_NAME");
		sendKeys("qq_NAME", data.get("qq"));
		
		clear("msn_NAME");
		sendKeys("msn_NAME", data.get("msn"));
		
		log.debug("inside testChangeInfo test is over.");
		Reporter.log("inside testChangeInfo test is over.");
		Reporter.log("<br>");
	}

}
