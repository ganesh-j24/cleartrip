package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.BaseTest;

public class ClearTripHome extends BaseTest
{
	public ClearTripHome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="RoundTrip")
	WebElement roundtrip;
	
	@FindBy(id="FromTag")
	WebElement SourceLoc;
	
	@FindBy(id="ToTag")
	WebElement DestinationLoc;
	
	@FindBy(id="DepartDate")
	WebElement DeptDate;
	
	@FindBy(id="ReturnDate")
	WebElement ReturnDate;
	
	@FindBy(id="Adults")
	WebElement Adults;
	
	@FindBy(id="Childrens")
	WebElement kids;
	
	@FindBy(id="SearchBtn")
	WebElement Searchbtn;
	
	public void trip()
	{
		roundtrip.click();
	}
	
	public void source(String loc)
	{
		SourceLoc.clear();
		SourceLoc.sendKeys(loc);
	}
	
	public void dest(String loc)
	{
		DestinationLoc.clear();
		DestinationLoc.sendKeys(loc);
	}
	
	public void startdate(String date)
	{
		DeptDate.clear();
		DeptDate.sendKeys(date);
	}
	
	public void enddate(String date)
	{
		ReturnDate.clear();
		ReturnDate.sendKeys(date);
	}
	
	public void adult(String val)
	{
		Select s=new Select(Adults);
		s.selectByValue(val);
	}
	
	public void kid(String val)
	{
		Select s=new Select(kids);
		s.selectByValue(val);
	}
	
	public void search()
	{
		Searchbtn.click();
	}
	
}
