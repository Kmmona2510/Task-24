package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.Homepage;

public class TC002_signintest extends ProjectSpecification{
	
	//get data to excel file
	@BeforeTest
	public void excelsheet() {
		 excelfile ="signindata";
		 
		
	}

	//use dataprovider to get data
	@Test(dataProvider="exceldata")
	public void signin(String name,String password,String fieldmatch ) throws InterruptedException {
		
		Homepage signinobj=new Homepage(driver);
		signinobj.signinbutton()
		.username(name)
		.password(password)
		.signupbutton();
		
		//use asserttion for verification
		Thread.sleep(30000);	
		if(fieldmatch.contains("correct")) {
			//use alert interface to handle the alert
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println(text);
			alert.accept();
			Assert.assertEquals(text, "This user already exist.");
			
		
		}
				
		
		else {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println(text);
			alert.accept();
			Assert.assertEquals(text,"Please fill out Username and Password." );
			System.out.println("Enter correct password");
			
		}
		
		
		
	}

}
