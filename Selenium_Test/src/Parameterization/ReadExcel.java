package Parameterization;



import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcel {
	public static void main(String[] args) throws Exception {
		File src= new File("D:\\data.xlsx");
		//using Java API specify workbook path
		FileInputStream fis = new FileInputStream(src);
		//to load entire workbook use XSSFWorkbook class
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);  //XSS used for .xlsx file
		//HSSFWorkbook wb1 = new HSSFWorkbook(fis); //HSS used for .xls file
		XSSFSheet sheet1 = wb1.getSheetAt(0);
		//to read 1st row and col from sheet 1

		String username=sheet1.getRow(2).getCell(0).getStringCellValue();
		String password=sheet1.getRow(2).getCell(1).getStringCellValue();

		System.out.println("Useraname is "+username);
		System.out.println("Password of the user is"+password);

		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\js-form-validation\\example-javascript-form-validation.html");
		//driver.get("D:\\js-form-validation\\js-form-validation.css");
		//driver.get("D:\\js-form-validation\\sample-registration-form-validation.js");
		driver.findElement(By.id("usrID")).sendKeys(username);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.close();
		wb1.close();  
	}

}
