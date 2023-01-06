package seleniumExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollDown {
	
	WebDriver driver;

	@BeforeTest
	// @BeforeClass
	public void launchApp() throws Exception {

		System.out.println("launching app");
		// driver = WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Switchto");
		//driver.manage().window().maximize();

	}

	@AfterTest
	// @AfterClass

	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");

	}

	@Test
	public void verifyRightClickTest() throws Exception {
		
		System.out.println("Execution is in progress");
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//button[@data-target='#myModal']")).click();
		System.out.println("Execution is in progress2");
	}

}
