package com.flipkart.BNPLpackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class Pqr 
{

 
 @Factory
	public Object[] factories()
	{
		Object[] data = new Object[5];
				for (int i = 0; i < 5; i++) {
					data[i]= new Pqr();
				}
		return data;
		
	}
 
 @Test
	public void launch()
	{
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.close();
	}
}
