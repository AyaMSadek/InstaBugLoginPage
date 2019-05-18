package org.testing.automation;

import org.testng.annotations.Test;
import org.testng.Assert;

public class InstaBugLoginNegativePaths {
	InstaBugLogin InstaBug;

	// Verify that validation message is displayed when user leaves Email as blank
	@Test (priority = 0)
	public void InvalidEmail_ValidationMessage() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		boolean expectedResult = true;
		boolean actualResult;
		actualResult = InstaBug.InvalidEmailValidationMessage(Config.Password);
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Verify that validation message is displayed when user enters password less
	// than 6 characters
	@Test (priority = 1)
	public void InvalidPassword_ValidationMessage() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		boolean expectedResult = true;
		boolean actualResult;
		actualResult = InstaBug.InvalidPasswordValidationMessage(Config.UserName);
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Login with wrong Email format
	@Test (priority = 2)
	public void InvalidEmail() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		boolean expectedResult = false;
		boolean actualResult;
		actualResult = InstaBug.loginWithInvalidEmail(Config.InvalidUserName);
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Login with wrong password
	@Test (priority = 3)
	public void WrongPassword() throws InterruptedException {
		InstaBug = new InstaBugLogin();
		boolean expectedResult = true;
		boolean actualResult;
		actualResult = InstaBug.loginWithInvalidPassword(Config.UserName, Config.InvalidPassword);
		Assert.assertEquals(actualResult, expectedResult);
	}


}
