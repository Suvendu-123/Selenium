package com.flipkart.BNPLpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Abc {
	WebDriver driver;
	
	
	@BeforeTest
	//@Parameters({"browser"})
	public void launch()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
	}
	
	@Test
	@Parameters({"uname", "pwd"})
	public void login(String uname, String pwd) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']")).sendKeys(pwd,Keys.ENTER);
		Thread.sleep(5000);
		
	}
	@Test
	public void search() throws Exception
	{
		driver.findElement(By.name("q")).sendKeys("Red mi 4", Keys.ENTER);
		Thread.sleep(5000);
		WebElement x=driver.findElement(By.xpath("//span[@class='_2yAnYN']"));
		System.out.println(x.getText());
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
