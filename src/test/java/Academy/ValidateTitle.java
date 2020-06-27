package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateTitle extends Base{

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void InitBrowser() throws IOException {
		driver = Initializedriver();
		log.info("DRiver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Website launched for validate tile class");
	}

	@Test

	public void ValidateTitl() throws IOException {
		
		LandingPage lp = new LandingPage(driver);

		Assert.assertEquals(lp.ValTitle().getText(), "FEATURED COURSES1235");
		log.info("Succefully Validated ");
	}

	@AfterTest

	public void teardown() {
		driver.close();
		driver = null;
		
	}
}
