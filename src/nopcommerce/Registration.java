package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ankita
 */
public class Registration extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
   // private WebDriver driver;
    @Before
    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessFully() {

        clickOnElement(By.xpath("//a[@class='ico-register']"));
    }

    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {

        clickOnElement(By.xpath("//a[@class='ico-register']"));
        clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Ankita");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Kaswala");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "1");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), "July");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), "1986");

        Thread.sleep(2000);
        Random anyEmail = new Random();
        int randomInt = anyEmail.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), +randomInt + "@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "Testing Team");
        sendTextToElement(By.xpath("//input[@id='Password']"), "xyz123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "xyz123");
        clickOnElement(By.xpath("//input[@id='register-button']"));
        String expectedResult = "Your registration completed";
        String actualResult = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expectedResult, actualResult);


    }

    @After
    public void browserClosing() {
        driver.quit();
    }
}
