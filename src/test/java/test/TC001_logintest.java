package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Homepage;

public class TC001_logintest extends ProjectSpecification {
	//get test data to excel sheet
	@BeforeTest
	public void excelsheet() {
		 excelfile ="Testdata";
	
		
	}
	
	//provide data to dataprovider
	@Test(dataProvider="exceldata")
	public void login(String username,String password,String fieldmatch) throws InterruptedException {
		
		Homepage loginobj=new Homepage(driver);
		loginobj.loginbutton()
		.loginusername(username)
		.loginpassword(password)
		.loginbutton();
		
		//use assertion for verification
		Thread.sleep(30000);	
		if(fieldmatch.contains("both correct")) {
			WebElement actualtext = driver.findElement(By.id("nameofuser"));
			String text = actualtext.getText();
			System.out.println(text);
			Assert.assertEquals(text,"Welcome pranesh11@gmail.com");
		}
				
		
		else if(fieldmatch.equals("wrong username")) {
			//use alert interface to handle the alert
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println(text);
			alert.accept();
			Assert.assertEquals(text,"User does not exist." );
			System.out.println("Enter correct password");
			
		}
		
		else if(fieldmatch.equals("wrong password")) {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println(text);
			alert.accept();
			Assert.assertEquals(text, "Wrong password.");
			System.out.println("Enter the correct username");
		}
		
		else {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.accept();
			System.out.println(text);
			Assert.assertEquals(text, "User does not exist.");
			System.out.println("Enter the correct username and password");
		}
		
		
			
		}
		
		
		
	}
	
	


