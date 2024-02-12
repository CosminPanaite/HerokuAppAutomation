package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnsuccessfulLoginTest {

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
	public void unsuccesfullLogin() {
		page.goToLink();

		page.maximizeDriver();

		page.sendWrongCredentials();

		page.pressLogin();

		Assert.assertTrue(page.returnInvalidText());

		System.out.println("Test passes for our unsuccessful login");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
