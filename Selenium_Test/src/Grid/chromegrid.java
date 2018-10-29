package Grid;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class chromegrid {

	public static void main(String[] args) throws InterruptedException, MalformedURLException 

	{


		System.setProperty("webdriver.chromedriver.driver", "D:\\harshita\\NewDrivers\\chrome\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setCapability("webdriver.chromedriver.driver", "D:\\harshita\\NewDrivers\\chrome\\chromedriver.exe");

		capabilities.setPlatform(Platform.WINDOWS);
		//capabilities.setVersion(version);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), capabilities);
		try {
			driver.get("D:\\js-form-validation\\example-javascript-form-validation.html");
			System.out.println(driver.getTitle());

			driver.findElement(By.id("usrID")).sendKeys("Harshita");
			driver.findElement(By.id("pwd")).sendKeys("Ahuja");
			driver.findElement(By.id("usrname")).sendKeys("haahuja");
			driver.findElement(By.id("addr")).sendKeys("Rohini");
			WebElement count = driver.findElement(By.name("country"));
			Select country1 = new Select(count);
			country1.selectByIndex(2);
			driver.findElement(By.name("zip")).sendKeys("110004");
			driver.findElement(By.id("txtEmail")).sendKeys("harshitaahuja@gmail.com");
			List<WebElement> list = driver.findElements(By.id("gender"));
			list.get(1).click();
			driver.findElement(By.name("en")).click();
			driver.findElement(By.id("desc")).sendKeys("This is the registration page");
			driver.findElement(By.id("txtEmail")).sendKeys("harshitaahuja@gmail.com");

			//			driver.quit();
		}
		catch(Exception ex){
			System.out.println("Hello");
		}
		//driver.quit();
	}

}

