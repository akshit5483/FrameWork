package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.Loginpage;

public class Homepage extends Base {


	@Test(dataProvider = "getdata")

	public void basepagenavigation(String Username, String Password, String msg)
			throws IOException, InterruptedException {
		driver = Initializedriver();

		// log.info("Driver is initilized");
		driver.get(prop.getProperty("url"));
		// log.info("Website is launched for home page class");

		LandingPage l = new LandingPage(driver);
		l.getlogin().click();

		Loginpage lp = new Loginpage(driver);
		lp.PopulateEmailAddress().sendKeys(Username);
		lp.PopulatePassword().sendKeys(Password);
		lp.ClickonLoginButton().click();
		Thread.sleep(1000);
		driver.close();
	}

	@DataProvider

	public Object[][] getdata() {

		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestrictuser@jj.kk";
		data[0][1] = "lknkjb";
		data[0][2] = "non restric user";

		data[1][0] = "restrictuser@hh.pp";
		data[1][1] = "mklilnkl";
		data[1][2] = "only restric user";

		return data;

	}

	public void teardown() {

		driver.close();
		driver = null;
	}

}
