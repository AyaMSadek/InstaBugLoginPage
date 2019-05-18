package org.testing.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InstaBugLoginAlternativePaths {
	InstaBugLogin InstaBug;

	// Login with email that isn't signed up for InstaBug
	@Test (priority = 0)
	public void NotSignedUpAccount() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		boolean expectedResult = true;
		boolean actualResult;
		actualResult = InstaBug.loginWithNotSignedUpAccount(Config.NewUserName, Config.NewPassword);
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Login with email that is already logged in
	@Test (priority = 1)
	public void LoggedInAccount() throws Exception {
		InstaBug = new InstaBugLogin();
		boolean expectedResult = true;
		boolean actualResult;
		actualResult = InstaBug.loginWithLoggedInAccount(Config.UserName, Config.Password);
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Login with valid email and password and Navigate back from browser
	@Test (priority = 2)
	public void LoginThenNavigateBack() throws Exception {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/welcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.LoginThenNavigateBack(Config.UserName, Config.Password);
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Verify that clicking on back from browser after successful logout shouldn't
	// take user to logged in mode
	@Test (priority = 3)
	public void LogoutAndNavigationBack() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/login?redirect=~2Fwelcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.LogoutSuccessfullyAndNavigationBack(Config.UserName, Config.Password);
		Assert.assertEquals(actualResult, expectedResult);

	}

	// Verify that the user can login with password that has changed to a new one
	@Test (priority = 4)
	public void LoginWithChangedPassword() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		String expectedResult = "https://dashboard.instabug.com/welcome-to-instabug";
		String actualResult;
		actualResult = InstaBug.LoginWithNewPassword(Config.UserName, Config.Password, Config.NewPassword);
		Assert.assertEquals(actualResult, expectedResult);

	}
}
