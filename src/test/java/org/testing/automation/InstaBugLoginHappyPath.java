package org.testing.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InstaBugLoginHappyPath {
	InstaBugLogin InstaBug;

	@BeforeTest
	public void login() throws Exception {
		InstaBug = new InstaBugLogin();
	}

	@Test (priority = 0)
	public void Login() throws Exception {
		String expectedResult = "https://dashboard.instabug.com/welcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.login(Config.UserName, Config.Password);
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test (priority = 1)
	public void LoginWithGoogle() throws Exception {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/welcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.loginWithGoogle(Config.GoogleUserName, Config.GooglePassword);
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test (priority = 2)
	public void LoginWithGitHub() throws Exception {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/welcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.loginWithGitHub(Config.GitHubUserName, Config.GitHubPassword);
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test (priority = 3)
	public void LoginWithMicrosoft() throws Exception {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/welcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.loginWithMicrosoft(Config.MicrosoftUserName, Config.MicrosoftPassword);
		Assert.assertEquals(actualResult, expectedResult);

	}

	// Verify that the user is directed to the Login page when logging out
	// successfully
	@Test (priority = 4)
	public void LogoutIsDirectedToLoginPageSuccessfully() throws Exception {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/login";
		String actualResult;
		actualResult = InstaBug.LogoutSuccessfully(Config.UserName, Config.Password);
		Assert.assertEquals(actualResult, expectedResult);

	}

	// Verify that the user is directed to the right page when clicking on forgot
	// password link
	@Test (priority = 5)
	public void ForgotPasswordLink() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/forgot";
		String actualResult;
		actualResult = InstaBug.ForgotPassword();
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Verify that the user is directed to the sign up page when clicking on sign up
	// link
	@Test (priority = 6)
	public void SignUpLink() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/signup";
		String actualResult;
		actualResult = InstaBug.SignUpLink();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterTest
	public void driverClosing() {
		InstaBug.DriverTerminate();
	}

}
