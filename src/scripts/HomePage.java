package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pompages.ClearTripHome;
import utilities.BaseTest;

public class HomePage extends BaseTest
{
	@Test
	public void acheckflights() throws Exception
	{
		ClearTripHome cth=new ClearTripHome(driver);
		Thread.sleep(2000);
		cth.trip();
		cth.source("Bangalore, IN - Kempegowda International Airport (BLR)");
		cth.dest("Chennai, IN - Chennai Airport (MAA)");
		cth.startdate("Tue, 12 Feb, 2019");
		cth.enddate("Sat, 23 Feb, 2019");
		cth.adult("4");
		cth.kid("2");
		cth.search();
	}
	
	@Test
	public void blankdestination() throws Exception
	{
		ClearTripHome cth=new ClearTripHome(driver);
		cth.trip();
		cth.source("Bangalore, IN - Kempegowda International Airport (BLR)");
		cth.startdate("Tue, 12 Feb, 2019");
		cth.enddate("Sat, 23 Feb, 2019");
		cth.adult("4");
		cth.kid("2");
		cth.search();
		Thread.sleep(1000);
		String msg= "Sorry, but we can't continue until you fix everything that's marked in RED";
		String Err=driver.findElement(By.id("homeErrorMessage")).getText();
		Assert.assertEquals(msg,Err);
	}
	
	@Test
	public void blankenddate() throws Exception
	{
		ClearTripHome cth=new ClearTripHome(driver);
		cth.trip();
		cth.source("Bangalore, IN - Kempegowda International Airport (BLR)");
		cth.dest("Chennai, IN - Chennai Airport (MAA)");
		cth.startdate("Tue, 12 Feb, 2019");
		cth.enddate("");
		cth.adult("4");
		cth.kid("2");
		cth.search();
		Thread.sleep(1000);
		String msg= "Sorry, but we can't continue until you fix everything that's marked in RED";
		String Err=driver.findElement(By.id("homeErrorMessage")).getText();
		Reporter.log(Err);
		Assert.assertEquals(msg,Err);
	}
	
	@Test
	public void blanksource() throws Exception
	{
		ClearTripHome cth=new ClearTripHome(driver);
		cth.trip();
		cth.dest("Chennai, IN - Chennai Airport (MAA)");
		cth.startdate("Tue, 12 Feb, 2019");
		cth.enddate("Sat, 23 Feb, 2019");
		cth.adult("4");
		cth.kid("2");
		cth.search();
		Thread.sleep(1000);
		String msg= "Sorry, but we can't continue until you fix everything that's marked in RED";
		String Err=driver.findElement(By.id("homeErrorMessage")).getText();
		Assert.assertEquals(msg,Err);
	}
	
	
	@Test
	public void blankstartdate() throws Exception
	{
		ClearTripHome cth=new ClearTripHome(driver);
		cth.trip();
		cth.source("Bangalore, IN - Kempegowda International Airport (BLR)");
		cth.dest("Chennai, IN - Chennai Airport (MAA)");
		cth.enddate("Sat, 23 Feb, 2019");
		cth.adult("4");
		cth.kid("2");
		cth.search();
		Thread.sleep(1000);
		String msg= "Sorry, but we can't continue until you fix everything that's marked in RED";
		String Err=driver.findElement(By.id("homeErrorMessage")).getText();
		Assert.assertEquals(msg,Err);
	}
	
	
	@Test
	public void blankinvalidenddate() throws Exception
	{
		ClearTripHome cth=new ClearTripHome(driver);
		cth.trip();
		cth.source("Bangalore, IN - Kempegowda International Airport (BLR)");
		cth.dest("Chennai, IN - Chennai Airport (MAA)");
		cth.startdate("Tue, 12 Feb, 2019");
		cth.enddate("Sat, 23 Jan, 2019");
		Thread.sleep(2000);
		cth.adult("4");
		cth.kid("2");
		cth.search();
		Thread.sleep(5000);
		String msg= "Looks like your dates are in the the past";
		String Err=driver.findElement(By.xpath("//div [@class='messageScreen']//h2")).getText();
		Assert.assertEquals(msg,Err);
	}
}
