package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {

	WebDriver driver;
	@FindBy(how = How.ID, using = "username")
	private WebElement username;
	@FindBy(how = How.ID, using = "password")
	private WebElement password;
	@FindBy(how = How.TAG_NAME, using = "i")
	private WebElement login;
	@FindBy(how = How.ID, using = "flash")
	private WebElement yourUsernameIs;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'button secondary')]")
	private WebElement logout;
	@FindBy(how = How.ID, using = "flash")
	private WebElement youLoggedInto;
	@FindBy(how = How.ID, using = "flash")
	private WebElement youLoggedOut;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToLink() {
		driver.get("https://the-internet.herokuapp.com/login");
	}

	public void maximizeDriver() {
		driver.manage().window().maximize();
	}

	public void sendWrongCredentials() {
		username.sendKeys("Cosmin2121");
		password.sendKeys("123456");

	}

	public void clearCredentials() {
		username.clear();
		
		password.clear();

	}

	public boolean returnInvalidText() {
		System.out.println(yourUsernameIs.getText());
		return yourUsernameIs.getText().contains("Your username is invalid!");
	}

	public boolean returnAreaForGoodLogin() {

		return youLoggedInto.getText().contains("You logged into a secure area!");
	}

	public boolean logoutSuccesfully() {

		return youLoggedOut.getText().contains("You logged out of the secure area!");
	}

	public void sendGoodCredentials() {
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
	}

	public void pressLogin() {
		login.click();
	}

	public void quitDriver() {
		driver.quit();
	}

	public void logoutFromSite() {
		logout.click();
	}

	public void navigateBackOnSite() {
		driver.navigate().back();

	}

	public void waitForEveryStep() throws InterruptedException {
		Thread.sleep(2500);

	}

}
