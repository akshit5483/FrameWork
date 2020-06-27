package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver ;
	Properties prop = new Properties();


	public WebDriver Initializedriver() throws IOException 
	{


		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browsername = prop.getProperty("browser"); //If we write this thn it will look into properties file

		//String browsername = System.getProperty("browser"); // If we write this thn it will look look into maven

		if (browsername.contains("chrome")) 
		{

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akshit Kataria\\E2EProjects\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();  // chrome options is a class

			if (browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver=new ChromeDriver(options);
		}

		else if (browsername.equals("firefox"))
		{

			System.setProperty("webdriver.firefox.driver", "D:\\AllSelenium jars\\Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		else if (browsername.equals("IE"))
		{

			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}	


	public void Screenshot(String result) throws IOException {


		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File ("D://DemoScrenshots//" +result+
				".png"));

	}

}
