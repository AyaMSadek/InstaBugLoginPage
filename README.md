# InstaBugLoginPage
Automation testing for Login process For InstaBug application. Using Selenium webDriver-Java, through TestNG Framework.

The test should do the following steps:
1) Open InstaBug website https://dashboard.instabug.com.
2) Login with different ways:
* Login with saved valid email and valid password.
* Login with GitHub, Google and Microsoft.
* Verify that "Forgot Password" link is directed to the Forgot password page successfully. 
* Verify that "Sign Up" link is directed to the sign up page successfully.
* Verify that the user is directed to the login page successfully when logging out.
* Login with a logged-in account.
* Login with an account that isn't signed up for InstaBug.
* Verify that the user isn't logged out when navigating back from the browser after logging in successfully.
* Verify that the user isn't logged in when navigating back from the browser after logging out successfully.
* Verfiy that the user can login with the changed new password.
* Login with invalid email or password.
* Verify that the validation messages are displayed below "Email" & "Password" when logging in with invalid credentials.
* Verfiy that the login button is disabled if the Email is invalid.
 

**And this is the results report using TestNG framework**
![alt text](https://github.com/AyaMSadek/InstaBugLoginPage/blob/master/TestNG.png)

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.
# Tools
* Selenium WebDriver
* Selenium Standalone Server
* TestNG Framework
* Maven

# Requirements 
* Selenium chrom driver 3.3
* Selenium standalone driver 3.14
* Chrome and Chromedriver
* Java 1.8
# Installing
1) Install Java on your computer
         Download and install the Java Software Development Kit (JDK).
         
2) Install Eclipse IDE
         Download "Eclipse IDE for Java Developers". Be sure to choose correctly between Windows 32 Bit and 64 Bit versions. 
         
3) Download the Selenium Java Client Driver
         You will find client drivers for other languages there, but only choose the one for Java. 
         
4) Configure Eclipse IDE with WebDriver
* Launch the "eclipse.exe" file inside the "eclipse" folder, the executable should be located on C:\eclipse\eclipse.exe.
* When asked to select for a workspace, just accept the default location.

5) Install/Add TestNG plugin to Eclipse.

6) Run **testng.xml** File.
