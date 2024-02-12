package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfullyLogout {

	WebDriver driver;
	BaseClass page;

	@BeforeMethod
	public void setup() {

		// retrieve base path to add it to the chrome driver
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");

		page = new BaseClass(driver);
	}

	@Test(priority = 1)
	public void succesfullLogout() {
		page.goToLink();

		page.maximizeDriver();

		page.sendGoodCredentials();

		page.pressLogin();

		page.logoutFromSite();

		Assert.assertTrue(page.logoutSuccesfully());

		System.out.println("Test passes for our successful logout from site!");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}