package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	protected static WebDriver driver;
	protected static WebDriverWait expWait;
	protected static JavascriptExecutor js;
	protected static Actions actions;
//	protected static ChromeOptions options;

	public void init() {

//		options = new ChromeOptions();

//		options.setAcceptInsecureCerts(false);
////		accepting the insecure webapps from privacy issue
//
//		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

//		options.addArguments("--incognito");

//		File adBlockerCrxFile = new File("D:\\selenium-files\\crxforadblocker\\adblock.crx");
//
//		options.addExtensions(adBlockerCrxFile);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		expWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);

	}

	public void tearDown() {

		driver.quit();

	}

	public String urlAssert() {

		return driver.getCurrentUrl();

	}

	public void switchToWindow(String windowid) {

		driver.switchTo().window(windowid);
	}

	public void click(By locator) {

		driver.findElement(locator).click();

	}

	public void enterValue(By locator, String text) {
		enterText(locator, text);
	}

	public void enterText(By locator, String text) {

		driver.findElement(locator).sendKeys(text);

	}

}
