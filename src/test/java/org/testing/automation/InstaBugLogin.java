package org.testing.automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstaBugLogin {

	WebDriver driver;

	InstaBugLogin() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://dashboard.instabug.com/login?redirect=~2F");
		driver.manage().window().maximize();
	}

	// LOGIN
	public String login(String username, String password) throws InterruptedException {
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// LOGIN WITH GOOGLE
	public String loginWithGoogle(String username, String password) throws InterruptedException {
		driver.findElement(By.id("loginWithGoogleFirstDesign")).click();
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// LOGIN WITH GITHUB
	public String loginWithGitHub(String username, String password) throws InterruptedException {
		driver.findElement(By.id("loginWithGitHubFirstDesign")).click();
		driver.findElement(By.id("login_field")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// LOGIN WITH MICROSOFT
	public String loginWithMicrosoft(String username, String password) throws InterruptedException {
		driver.findElement(By.className("c-authentication__microsoft-button-icon")).click();
		driver.findElement(By.name("loginfmt")).sendKeys(username);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// Logout is directed to Login page successfully
	public String LogoutSuccessfully(String username, String password) throws InterruptedException {
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("span[class=\"u-text-smal c-top-navbar-menu__profile-item-name\"]")).click();
		driver.findElement(By.className("-height-48")).click();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// Forgot Password Way
	public String ForgotPassword() throws InterruptedException {
		driver.findElement(By.className("o-link--light-grey")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url;
	}

	// Sign Up Way
	public String SignUpLink() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href ='/signup']")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url;
	}

	// Validation Message is displayed with invalid email
	public boolean InvalidEmailValidationMessage(String password) throws InterruptedException {
		driver.findElement(By.id("developer_email")).sendKeys("     ");
		driver.findElement(By.id("password")).sendKeys(password);
		return driver.findElement(By.className("c-hint--error")).isDisplayed();
	}

	// Validation Message is displayed with invalid password that is less than 6
	// characters
	public boolean InvalidPasswordValidationMessage(String username) throws InterruptedException {
		//driver.findElement(By.id("developer_email")).clear();
		//driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1");
		driver.findElement(By.id("developer_email")).sendKeys(username);
		return driver.findElement(By.cssSelector("p[class=\"c-hint c-hint--error\"]")).isDisplayed();
	}

	// LOGIN WITH INVALID MAIL Format
	public boolean loginWithInvalidEmail(String username) throws InterruptedException {
		//driver.findElement(By.id("developer_email")).clear();
		//driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("developer_email")).sendKeys(username);
		return driver.findElement(By.className("c-button--info")).isEnabled();
	}

	// LOGIN WITH Wrong PASSWORD
	public boolean loginWithInvalidPassword(String username, String password) throws InterruptedException {
		//driver.findElement(By.id("developer_email")).clear();
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		return driver.findElement(By.className("callout")).isDisplayed();
	}

	// LOGIN WITH EMAIL THAT ISN'T SIGNED UP
	public boolean loginWithNotSignedUpAccount(String username, String password) throws InterruptedException {
		//driver.findElement(By.id("developer_email")).clear();
		//driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		return driver.findElement(By.className("callout")).isDisplayed();
	}

	// LOGIN WITH LOGGED IN ACCOUNT
	public boolean loginWithLoggedInAccount(String username, String password) throws InterruptedException {
		driver.findElement(By.id("developer_email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		return driver.findElement(By.className("c-button--info")).isDisplayed();

	}

	// LOGIN THEN NAVIGATE BACK FROM BROWSER
	public String LoginThenNavigateBack(String username, String password) throws InterruptedException {
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		driver.navigate().back();
		String url = driver.getCurrentUrl();
		return url;
	}

	// Logout successfully then navigate back
	public String LogoutSuccessfullyAndNavigationBack(String username, String password) throws InterruptedException {
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("span[class=\"u-text-smal c-top-navbar-menu__profile-item-name\"]")).click();
		driver.findElement(By.className("-height-48")).click();
		driver.navigate().back();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// Login with the changed new password
	public String LoginWithNewPassword(String username, String password, String newPassword)
			throws InterruptedException {
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.className("c-button--info")).isDisplayed())
			driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("span[class=\"u-text-smal c-top-navbar-menu__profile-item-name\"]")).click();
		driver.findElement(By.cssSelector("a[href=\"/profile/\"]")).click();
		driver.findElement(By.id("developer_new_password")).sendKeys(newPassword);
		driver.findElement(By.id("developer_new_password_confirmation")).sendKeys(newPassword);
		driver.findElement(By.id("developer_current_password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class=\"c-button c-button--info c-button--block c-button--large\"]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.className("o-link")).click();
		driver.findElement(By.id("developer_email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(newPassword);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("c-button--info")).click();
		Thread.sleep(10000);
		return driver.getCurrentUrl();
	}

	public void DriverTerminate() {
		driver.close();
	}
}
