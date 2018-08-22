package com.flipkart.BNPLpackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Gmail 
{
	WebDriver driver;
	@Test(dataProvider="uname")
	public void unameTest(String un,String pwd) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		
		WebElement e=driver.findElement(By.name("identifier"));
		e.sendKeys(un,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.close();
		
		
	}
	 
	public static String excelReader(int rn, int cn) throws Exception
	{
		
			FileInputStream fis= new FileInputStream("C:\\Users\\Arina\\Desktop\\Book1.xlsx");
			Workbook wb= new XSSFWorkbook(fis);
			 Sheet sh = wb.getSheetAt(0);
		
		
		
		return sh.getRow(rn).getCell(cn).getStringCellValue();
		
	}
	@DataProvider
	public Object[][] uname() throws Exception 
	{
		String [][] arr= new String[3][2];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j]=Gmail.excelReader(i, j);
				
			}
			
		}
		return arr;
		
	}
}
