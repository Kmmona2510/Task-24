package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecification;

public class Loginpage extends ProjectSpecification {
	
	//use findby annotation to locate the element
	@FindBy(id="loginusername")
	WebElement loginusername;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath= "//button[text()='Log in']")
	WebElement logbutton;
	
	//initialize the page factory
	public Loginpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	//data username 
	public Loginpage loginusername(String uname) {
		loginusername.sendKeys(uname);
		return this;
	}
	
	//data password
	public Loginpage loginpassword(String loginpassword) {
		password.sendKeys(loginpassword);
		return this;
	}
	
	//click login button
	public Loginpage loginbutton() {
		logbutton.click();
						
		return this;
		
	}
	
	
	
}
