package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class Signinpage  extends ProjectSpecification {
	
	//use finby annotations to locate webelements
	@FindBy(id="sign-username")
	WebElement user_name;
	
	@FindBy(id = "sign-password")
	WebElement password;
	
	@FindBy(xpath ="//button[text()='Sign up']")
	WebElement button;
	
	//initialize the page factory
	public Signinpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//give signin data to usernamefield
	public Signinpage username(String name) {
		user_name.sendKeys(name);
	
		return this;
		
	}
	
	//give password  data to passwordfield
	public Signinpage password(String passwordvalue) {
		
		password.sendKeys(passwordvalue);
		
		return this;
			
	}
	
	
	//click signin button
	public Signinpage signupbutton() {
		button.click();
		return this;
		
	}
	
	

}
