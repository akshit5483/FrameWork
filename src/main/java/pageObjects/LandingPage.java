package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin = By.xpath("//span[text()='Login']");
	By Title = By.xpath("//div[@class='text-center']/h2");
	By ContactTab = By.xpath("//a[text()='Contact']");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getlogin() {
		return driver.findElement(signin);
	}

	public WebElement ValTitle() {
		return driver.findElement(Title);
	}
	
	public WebElement ValidatecontactTab()
	{
		return driver.findElement(ContactTab);
	}
}