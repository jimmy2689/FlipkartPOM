package com.qa.flipkart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BasePage;
import com.qa.flipkart.pages.LoginPage;

public class LoginTest {
	public LoginPage lp;
	public BasePage bp;
	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		bp = new BasePage();
		prop = bp.init_properties();
		String browser = prop.getProperty("browser");
		driver = bp.init_driver(browser);
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title,
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}

	@Test(priority = 2)
	public void loginLinkTest() {
		boolean flag = lp.verifyLoginPageLink();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 3)
	public void validLogin() {
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
