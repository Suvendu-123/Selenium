package com.flipkart.BNPLpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Abc {
	WebDriver driver;
	
	
	@Test(dataProvider="mobile")
	//@Parameters({"browser"})
	
	public void launch(String mob) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
	
	
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys("7978049852");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']")).sendKeys("monty4171",Keys.ENTER);
		Thread.sleep(5000);
		
	
		driver.findElement(By.name("q")).sendKeys(mob, Keys.ENTER);
		Thread.sleep(2000);
		//WebElement x=driver.findElement(By.xpath("//span[@class='_2yAnYN']"));
		//System.out.println(x.getText());
		
		driver.close();
	}
	public static String excelReader(int rn, int cn) throws Exception
	{
	
		
			FileInputStream fis= new FileInputStream(new File ("C:\\Users\\Arina\\Desktop\\Book1.xlsx"));
			Workbook wb= new XSSFWorkbook(fis);
			Sheet sh = wb.getSheetAt(1);
		
		
			return sh.getRow(rn).getCell(cn).getStringCellValue();
		
	}
	@DataProvider
	public Object[][] mobile() throws Exception 
	{
		String [][] arr= new String[4][1];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 1; j++) {
				arr[i][j]=Abc.excelReader(i, j);
				
			}
			
		}
		return arr;
		
	}
	
	
}
