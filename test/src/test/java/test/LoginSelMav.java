package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSelMav {
	static String browser;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		browserSetup();
		browserConfiguration();
		runTests(); 
	}

	public static void browserSetup() {
		browser = "Firefox";

	}
	public static void browserConfiguration() {
		if (browser.contains("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.contains("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
	public static void runTests() throws InterruptedException{
		//driver.get("https://odpcf123.extension-center-sbx.cfapps.sap.hana.ondemand.com/loginservice");
		
		driver.get("https://odpcf123.extension-center-sbx.cfapps.sap.hana.ondemand.com/#/services");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		WebElement userName =driver.findElement(By.id("j_username"));
		if(userName.isDisplayed()) {
			userName.sendKeys("cf.team.puser@gmail.com");
			WebElement loginContinueBtn = driver.findElement(By.id("logOnFormSubmit"));
			loginContinueBtn.click();
			WebElement password =driver.findElement(By.id("j_password"));
			password.sendKeys("Ak09sansu");
			WebElement loginSubmitBtn = driver.findElement(By.id("logOnFormSubmit"));
			loginSubmitBtn.click();
		}
		
		
		driver.close();
//		driver.quit();
	}

}
