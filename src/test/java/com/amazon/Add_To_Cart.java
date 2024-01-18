package com.amazon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Add_To_Cart {
	 public WebDriver driver;
	   
	   @BeforeTest 
	   public void openApplication() throws InterruptedException {
		   
	       driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   	driver.get("https://www.amazon.com/");
	   
	       
	   }
	   @Test(priority=1)
		public void Login() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
			WebElement login=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
			login.click();
			driver.findElement (By.id("ap_email")).sendKeys("8885991956");
			driver.findElement (By.id("continue")).click();
			driver.findElement (By.id("ap_password")).sendKeys("Prabhu@123");
			driver.findElement (By.id("signInSubmit")).click();

	   }
	   @Test(priority=2,dependsOnMethods= {"Login"})
	   public void Add_To_Cart() throws InterruptedException {
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.findElement (By.id("twotabsearchtextbox")).sendKeys("ear pods");
			Thread.sleep(2000);  //To identify the web element
			
			driver.findElement(By.xpath("//div[@id='nav-flyout-searchAjax']/div[2]/div/div[1]/div[3]/div/div[1]")).click();
			driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
			Thread.sleep(2000); //To identify the web element
			driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]")).click();
	   }
	   @Test(priority=3,dependsOnMethods= {"Add_To_Cart"})
			public void close()
			{
				driver.close();
			}
			


	      
	   }  
	   
	   
