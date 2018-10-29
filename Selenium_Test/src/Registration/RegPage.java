package Registration;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class RegPage {

	WebDriver driver;
	//creating parameterized constructor to initialize WebDriver reference
	public RegPage(WebDriver driver)
	{
		this.driver =driver;
	}
	@FindBy(xpath="html/body/h1")
	WebElement heading;

	@FindBy(id="usrID")
	@CacheLookup // to store the element in cache memory
	WebElement userid;

	//using How class	
	@FindBy(how=How.NAME, using="passid")
	@CacheLookup
	WebElement password;

	//using Xpath
	@FindBy(how=How.ID, using="usrname")
	@CacheLookup
	WebElement username;

	//using Xpath
	@FindBy(how=How.NAME, using="address")
	@CacheLookup
	WebElement address;


	//using name for
	@FindBy(how=How.XPATH, using="html/body/form/ul/li[10]/select/option[4]")// f. india is selected
	@CacheLookup
	WebElement country;


	//using Xpath
	@FindBy(how=How.NAME, using="zip")
	@CacheLookup
	WebElement zip;

	//using Xpath
	@FindBy(how=How.NAME, using="email")
	@CacheLookup
	WebElement email;

	//using name for
	@FindBy(how=How.XPATH, using="html/body/form/ul/li[17]/input") //g. female is selected
	@CacheLookup
	WebElement RADIO1;

	//using name for
	@FindBy(how=How.XPATH, using="html/body/form/ul/li[19]/input") //h. english is selected
	@CacheLookup
	WebElement CHECK1;



	//using Xpath
	@FindBy(how=How.NAME, using="desc")
	@CacheLookup
	WebElement about;

	//@FindBy(linkText="Next")
	//WebElement Next;

	@FindBy(name="submit")
	@CacheLookup // to store the element in cache memory
	WebElement submit;

	public void login_misapp(String uid, String pass, String name,String add,String coun,String code,String mail,String desc)
	{
		userid.sendKeys(uid);
		password.sendKeys(pass);
		username.sendKeys(name);
		address.sendKeys(add);
		country.sendKeys(coun);
		zip.sendKeys(code);
		email.sendKeys(mail);
		//19. select sex
		RADIO1.click();

		//20. select language
		CHECK1.click();
		about.sendKeys(desc);
		submit.click();
	}

	//5. Enter user id.
	public void enterUserid(String id)
	{
		userid.sendKeys(id);
	}

	//7. Enter password
	public void enterPassword(String pw)
	{
		password.sendKeys(pw);
	}

	//9. Enter name
	public void enterName(String nm)
	{
		username.sendKeys(nm);
	}

	//11. Enter address
	public void enterAddress(String ad)
	{
		address.sendKeys(ad);
	}

	//13. select country
	public void enterCountry(String cn)
	{
		country.sendKeys(cn);
	}

	//15. Enter zip code
	public void enterzip(String cd)
	{
		zip.sendKeys(cd);
	}

	//17. Enter email id
	public void enterEmail(String ml)
	{
		email.sendKeys(ml);
	}

	//22. Enter data in about field
	public void enterAbout(String ds)
	{
		about.sendKeys(ds);

	}
	public void verifyTitle(String expected)
	{
		String actual = driver.getTitle();
		if(actual.contentEquals(expected))
		{
			System.out.println("Title Verification - Passed");
		}
		else
		{
			System.out.println("Title Verification - Failed");
			driver.quit();
		}

	}
	public void verifyHeading(String expected)
	{
		String actual = heading.getText();
		if(actual.contentEquals(expected))
		{
			System.out.println("Heading Verification - Passed");

		}
		else
		{
			System.out.println("Heading Verification - Failed");
			driver.quit();
		}

	}
	//4. To ensure that user id text box is available.
	public void verifyUserid() throws InterruptedException  
	{
		Boolean id=userid.isDisplayed();
		if(id=true) 
		{
			System.out.println("User Id textbox present");
			enterUserid("");
			submit.click();
			Thread.sleep(3000);;
			Alert alert = driver.switchTo().alert();
			//6. To ensure that user id alert box displays the message "User Id should not be empty / length be between 5 to 12".
			String expectedAlertMessage="User Id should not be empty / length be between 5 to 12";
			String actualAlertMessage= driver.switchTo().alert().getText();
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for user id - Passed");
				alert.accept();
				enterUserid("Harshita");
			}
			else
			{
				System.out.println("Alert message verification for userid - Failed");
			}

		}
		else
		{
			System.out.println("UserId textbox not present");
		}

	}

	//4. To ensure that  text box is available.
	public void verifyPassword() throws InterruptedException  
	{
		Boolean pw=userid.isDisplayed();
		if(pw=true) 
		{
			//5. To ensure that password text box is available.
			System.out.println("Password textbox present");
			enterPassword("");
			submit.click();
			Thread.sleep(3000);;
			Alert alert = driver.switchTo().alert();
			//8. To ensure that password alert box displays the message "Password should not be empty / length be between 7 to 12".
			String expectedAlertMessage="Password should not be empty / length be between 7 to 12";
			String actualAlertMessage= driver.switchTo().alert().getText();
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for password - Passed");
				alert.accept();
				enterPassword("mypassword");
			}
			else
			{
				System.out.println("Alert message verification for password - Failed");
			}

		}
		else
		{
			System.out.println("Password textbox not present");
		}
	}


	public void verifyName() throws InterruptedException  
	{
		Boolean nm=username.isDisplayed();
		if(nm=true) 
		{
			//4. To ensure that  text box is available.
			System.out.println("Username textbox present");
			enterName("");
			submit.click();
			Thread.sleep(3000);;
			Alert alert = driver.switchTo().alert();
			//10. To ensure that password alert box displays the message "Username must have alphabets characters only.".
			String expectedAlertMessage="Username must have alphabet characters only";
			String actualAlertMessage= driver.switchTo().alert().getText();
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for username - Passed");
				alert.accept();
				enterName("Haahuja");
			}
			else
			{
				System.out.println("Alert message verification for username - Failed");
			}

		}
		else
		{
			System.out.println("Username textbox not present");
		}

	}

	public void verifyAddress() throws InterruptedException  
	{
		Boolean ad=address.isDisplayed();
		if(ad=true) 
		{
			//4. To ensure that  text box is available.
			System.out.println("Address textbox present");
			enterAddress("");
			submit.click();
			Thread.sleep(3000);;
			Alert alert = driver.switchTo().alert();
			//12. To ensure that password alert box displays the message "User address must have alpha numeric value".
			String expectedAlertMessage="User address must have alphanumeric characters only";
			String actualAlertMessage= driver.switchTo().alert().getText();
			System.out.println(actualAlertMessage);
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for address - Passed");
				alert.accept();
				enterAddress("7, rohini");
			}
			else
			{
				System.out.println("Alert message verification for address - Failed");
			}

		}
		else
		{
			System.out.println("Address textbox not present");
		}
	}

	public void verifyCode() throws InterruptedException  
	{
		Boolean cd=userid.isDisplayed();
		if(cd=true) 
		{
			//4. To ensure that  text box is available.
			System.out.println("Zip Code textbox present");
			enterzip("");
			submit.click();
			Thread.sleep(3000);;
			Alert alert = driver.switchTo().alert();
			//14. To ensure that password alert box displays the message "Zip code must have numeric characters only".
			String expectedAlertMessage="ZIP code must have numeric characters only";
			String actualAlertMessage= driver.switchTo().alert().getText();
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Zip Code - Passed");
				alert.accept();
				enterzip("110004");
			}
			else
			{
				System.out.println("Alert message verification for Zip Code - Failed");
			}

		}
		else
		{
			System.out.println("Zip Code textbox not present");
		}
	}

	public void verifyEmail() throws InterruptedException  
	{
		Boolean cd=userid.isDisplayed();
		if(cd=true) 
		{
			//4. To ensure that  text box is available.
			System.out.println("Email textbox present");
			enterEmail("");
			submit.click();
			Thread.sleep(3000);;
			Alert alert = driver.switchTo().alert();
			//18. To ensure that password alert box displays the message "Zip code must have numeric characters only".
			String expectedAlertMessage="You have entered an invalid email address!";
			String actualAlertMessage= driver.switchTo().alert().getText();
			if(expectedAlertMessage.contentEquals(actualAlertMessage))
			{
				System.out.println("Alert message verification for Email  - Passed");
				alert.accept();
				enterEmail("harshita@gmail");
			}
			else
			{
				System.out.println("Alert message verification for Email  - Failed");
			}

		}
		else
		{
			System.out.println("Email  textbox not present");
		}
	}


	public void enterAbout()
	{
		enterAbout("This is the registration form page.");
	}

}
