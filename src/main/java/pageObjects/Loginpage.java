package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

	WebDriver driver;

	By Email = By.xpath("//input[@id='user_email']");
	By Password = By.xpath("//input[@id='user_password']");
	By Loginbtn = By.xpath("//input[@value='Log In']");

	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement PopulateEmailAddress() {
		return driver.findElement(Email);
	}

	public WebElement PopulatePassword() {
		return driver.findElement(Password);
	}

	public WebElement ClickonLoginButton() {
		return driver.findElement(Loginbtn);
	}

}
