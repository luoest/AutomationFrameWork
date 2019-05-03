package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExcelReader;
import utilities.ExtentManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fils;
	public static Logger log = Logger.getLogger("mayThird");
	public static ExcelReader excel = new ExcelReader("D:\\JAVA_workspace\\JavaDataFrameWork\\src\\test\\resources\\excel\\testdata.xlsx");
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		PropertyConfigurator.configure("D:\\JAVA_workspace\\JavaDataFrameWork\\src\\test\\resources\\properties\\log4j.properties");
		
		if (driver == null) {
			fils = new FileInputStream("D:\\JAVA_workspace\\JavaDataFrameWork\\src\\test\\resources\\properties\\config.properties");
			config.load(fils);
			fils = new FileInputStream("D:\\JAVA_workspace\\JavaDataFrameWork\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fils);
			
			log.debug("config and OR files loaded");
			Reporter.log("config and OR files loaded");
			Reporter.log("<br>");
			
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
				browser = System.getenv("browser");
			}else {
				browser = config.getProperty("browser");
			}
			config.setProperty("browser", browser);
			
			if (config.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
			}else if (config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
			}else if (config.getProperty("browser").equals("ie")) {
				driver = new InternetExplorerDriver();
			}
			
			log.debug("start browser: " + config.getProperty("browser"));
			Reporter.log("start browser: " + config.getProperty("browser"));
			Reporter.log("<br>");
			
			driver.manage().window().maximize();
			driver.get(config.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			log.debug("maximize browser and navagate to: " + config.getProperty("url"));
			Reporter.log("maximize browser and navagate to: " + config.getProperty("url"));
			Reporter.log("<br>");
		}
	}
	public void sendKeys(String locator, String value) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		}
		log.debug("send keys: " + value + ", to element: " + locator);
		Reporter.log("send keys: " + value + ", to element: " + locator);
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "send keys: " + value + ", to element: " + locator);
		
	}
	public void click(String locator) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}
		log.debug("clicking on: " + locator);
		Reporter.log("clicking on: " + locator);
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "clicking on: " + locator);
		
	}
	public void clear(String locator) {
		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).clear();
		}else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		}else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).clear();
		}
		log.debug("clearing on: " + locator);
		Reporter.log("clearing on: " + locator);
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "clearing on: " + locator);
	}
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		driver.quit();
		System.out.println("All tests are complete.");
		log.debug("All tests are complete.");
		Reporter.log("All tests are complete.");
		Reporter.log("<br>");
	}
}
