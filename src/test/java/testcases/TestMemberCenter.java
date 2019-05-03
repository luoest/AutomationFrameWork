package testcases;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class TestMemberCenter extends TestBase{

	@Test
	public void testMemberCenter() {
		
		if (!TestUtil.isTestRunnable("testMemberCenter", excel)) {
			throw new SkipException("SKIP ====>>" + "testMemberCenter".toUpperCase());
		}
		
		log.debug("enter TestMemberCenter to test.");
		Reporter.log("enter TestMemberCenter to test.");
		Reporter.log("<br>");
		
		click("mem_XPATH");
		click("change_XPATH");
		
		log.debug("inside TestMemberCenter test is over.");
		Reporter.log("inside TestMemberCenter test is over.");
		Reporter.log("<br>");
	}
}
