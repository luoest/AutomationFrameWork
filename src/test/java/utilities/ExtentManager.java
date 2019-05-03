package utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		extent = new ExtentReports("D:\\JAVA_workspace\\JavaDataFrameWork\\target\\surefire-reports\\html\\extent.html",
				true, DisplayOrder.OLDEST_FIRST);
		extent.loadConfig(new File("D:\\JAVA_workspace\\JavaDataFrameWork\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		return extent;
	}
}
