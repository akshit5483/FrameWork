package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateNavigationBar extends Base {

	@BeforeTest
	public void InitBrowser() throws IOException {
		driver = Initializedriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void ValNavigationBar() {
		LandingPage lpp = new LandingPage(driver);
		Assert.assertTrue(lpp.ValidatecontactTab().isDisplayed());

	}

	@AfterTest

	public void teardown() {
		
		driver.close();
		driver = null;
	}

}
