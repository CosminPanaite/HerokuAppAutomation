package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		// retrieve base path to add it to the chrome driver
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		BaseClass page = new BaseClass(driver);

		System.out.println("Scenario for all operations on the site Herocku:");

		page.goToLink();
		page.waitForEveryStep();
		page.maximizeDriver();
		page.waitForEveryStep();
		page.sendWrongCredentials();
		page.waitForEveryStep();
		page.pressLogin();
		page.waitForEveryStep();
		page.navigateBackOnSite();
		page.waitForEveryStep();
		page.clearCredentials();
		page.waitForEveryStep();
		page.sendGoodCredentials();
		page.waitForEveryStep();
		page.pressLogin();
		page.waitForEveryStep();
		page.logoutFromSite();
		page.waitForEveryStep();
		page.quitDriver();

	}
}
