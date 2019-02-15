package utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	public WebDriver driver;
	
	static
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	}
	
	@BeforeMethod
	public void launchapp()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
	}
	
	@AfterMethod
	public void closeapp()
	{
		driver.close();
	}
}
