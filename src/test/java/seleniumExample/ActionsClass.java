package seleniumExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsClass {

	WebDriver driver;

	@BeforeTest
	// @BeforeClass
	public void launchApp() throws Exception {

		System.out.println("launching app");
		// driver = WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
		// create an object of configRead
		//driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}

	@AfterTest
	// @AfterClass

	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		System.out.println("closing app");

	}

	// @Test
	public void verifyRightClickTest() throws Exception {

		// Create an Object of Actions class

		Actions act = new Actions(driver);

		WebElement rightButton = driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		WebElement delete = driver.findElement(By.xpath("//span[contains(text(),'Del')]"));

		act.contextClick(rightButton).perform();
		Thread.sleep(2000);
		delete.click();

		// handle Alert
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(a.getText());
		Assert.assertTrue(a.getText().contains("delete"));

		a.dismiss();

	}

	//@Test
	public void verifyDoubleClickTest() throws Exception {

		// Create an Object of Actions class

		Actions act = new Actions(driver);

		WebElement doubleButton = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));

		act.doubleClick(doubleButton).perform();
		Thread.sleep(2000);

		// handle Alert
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(a.getText());
		Assert.assertTrue(a.getText().contains("double"));

		a.dismiss();
	}

	 @Test
	    public void verifyDragAndDropTest() throws Exception {

		 WebElement photoFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		 driver.switchTo().frame(photoFrame);
		 
	        // Create an Object of Actions class

	        Actions act = new Actions(driver);

	        WebElement img3 = driver.findElement(By.xpath("//h5[text()='High Tatras 3']"));
	        WebElement img4 = driver.findElement(By.xpath("//h5[text()='High Tatras 4']"));
	        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
	        
	        act.dragAndDrop(img3, trash).perform();
	        Thread.sleep(5000);
	        act.clickAndHold(img4).moveToElement(trash).release().perform();
	        Thread.sleep(3000);
	        
	        
	    }
	
}
