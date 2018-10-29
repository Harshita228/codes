package Registration;
//testNG program

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Registration.RegPage;

public class VerifyRegPage {
	
	WebDriver driver ;
	RegPage reg_page;
	public int TimeoutValue = 30;
			
	
	
	@Test(priority=1)
	public void TestCaseOne()
	{
		//1.	Launch the application browser
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//2.	Open the web page “Registartion.html “ in the browser.
		driver.get("D:\\js-form-validation\\example-javascript-form-validation.html");
		reg_page = PageFactory.initElements(driver, RegPage.class);
		
		//3.	Verify the title “JavaScript Form Validation using a sample registration form” of the page. 
		//The test should stop execution if the title of the page is not matching with the expected title.
		reg_page.verifyTitle("JavaScript Form Validation using a sample registration form");
		
		//4. Verify the heading  “Step 1: Personal Details ” of the page. 
		//The test should stop execution if the heading of the page is not matching with the expected heading.
		reg_page.verifyHeading("Registration Form");
		
	}         
	@Test(priority=2)
	public void TestCaseTwo() throws InterruptedException
	{
		//verifying whether text box is present and alert box is showing correct value.

		reg_page.verifyUserid();
		
	}
	
	@Test(priority=3)
	public void TestCaseThree() throws InterruptedException
	{
		//verifying whether text box is present and alert box is showing correct value.
		reg_page.verifyPassword();
	}
	
	@Test(priority=4)
	public void TestCaseFour() throws InterruptedException
	{
		
		reg_page.verifyName();
	}
	
	@Test(priority=5)
	public void TestCaseFive() throws InterruptedException
	{
		//verifying whether text box is present and alert box is showing correct value.
		reg_page.verifyAddress();
		
	}
	
	@Test(priority=6)
	public void TestCasesix() throws InterruptedException
	{
		
		//verifying whether text box is present and alert box is showing correct value.
		reg_page.verifyCode();
	}
		
		
	}
