package nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import utility.ReadConfig;

public class BaseTest {

	public WebDriver driver;

	public ReadConfig conf;

	// ctrl+shoift+O ------ auto import

	// pre-condition ---- @BeforeSuite---

	// Test

	// post-condition

	@Parameters("ibm_browser")
	@BeforeTest

	public void launchApp(String browser) throws Exception {
	//public void launchApp() throws Exception {

		System.out.println("launching app");

		//driver = WebDriverManager.chromedriver().create();
		
		 System.out.println("Execution on browser: " + browser);
		 Thread.sleep(3000);

	        //String browser = "chrome";

	        

	        

	        //driver = WebDriverManager.chromedriver().create();

	        //driver = WebDriverManager.edgedriver().create();

	        

	        

	        if(browser.equalsIgnoreCase("CHROME")) {	            
	           driver = new ChromeDriver();
	           // driver = WebDriverManager.chromedriver().create();
	        }
	        
	        else if(browser.equalsIgnoreCase("edge")) {
	        	//driver = WebDriverManager.edgedriver().create();
	            driver = new EdgeDriver();
	        }

	        else if(browser.equalsIgnoreCase("firefox")) {
	        	driver = WebDriverManager.firefoxdriver().create();
	        	driver = new FirefoxDriver();
	        }
	        
	        else {
	            System.out.println("execution on default browser: " + browser);
	            //default execution on chrome browser
	            //driver = WebDriverManager.chromedriver().create();
	            driver = new ChromeDriver();

	        }

		// create an object of configRead

		conf = new ReadConfig();

		System.out.println(conf.appURL());

		driver.get(conf.appURL());
		Thread.sleep(3000);
		driver.manage().window().maximize();

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");

	}

}
