package com.hyr.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void InitialiseBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		/*case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;*/
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browsername is invalid");
			break;
		}
		driver.manage().window().maximize();
	}

	@Parameters("sleepTime")
	@AfterTest
	public void TearDown(Long sleepTime) throws Exception {
		System.out.println(sleepTime);
		Thread.sleep(sleepTime);
		driver.quit();
	}

	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
		driver.get(url);
	}

	@Parameters({ "username", "password" })
	@Test
	public void EnterLoginDetails(String userName, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	}

	@AfterTest
	public void Teardown() {
		driver.quit();
	}

	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}

	@Test
	public void verifyMyInfo() {
		System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
		driver.quit();
	}

	@Test
	public void verifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		driver.quit();
	}

}
