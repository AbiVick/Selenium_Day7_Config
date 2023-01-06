package googlePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	@Test
	public void google() throws Exception {

		// WebDriver driver = WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone14" + Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("Page Title is " + driver.getTitle());
		Thread.sleep(3000);
		driver.close();

	}

}
