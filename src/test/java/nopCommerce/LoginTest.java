package nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

	@Test

    public void verifyLogin() throws Exception {

		Thread.sleep(3000);
        WebElement txt_Email = driver.findElement(By.xpath("//input[@id='Email']"));
        Thread.sleep(3000);
        txt_Email.clear();
        Thread.sleep(3000);
        txt_Email.sendKeys(conf.getEmail());      

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type=\"password\"]")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(conf.getPass());
        driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
        System.out.println("login test case'");
        Thread.sleep(4000);

        //validation step

        String actualTitle = driver.getTitle();
        System.out.println("Application Title after login: " + actualTitle);
        Thread.sleep(4000);

        //click on Logout

        driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();

    }

}
