package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

//Homepage actions
public class Homepage extends ProjectSpecification {

	//use pagefactory to find elements
	@FindBy(id= "login2")
	WebElement login;
	
	@FindBy(id = "signin2")
	WebElement signin;
	
	public Homepage(WebDriver driver) {
		this.driver =driver;
		//page factory initialization
		PageFactory.initElements(driver, this);
		
	}
	
	//click signin button to navigate sign in page
	public Signinpage signinbutton() {
		signin.click();
		return new Signinpage(driver);
	}
	
	//click login button to navigate login page
	public Loginpage loginbutton() {
		login.click();
		return new Loginpage(driver);
	}
}