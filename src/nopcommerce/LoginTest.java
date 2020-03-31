package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

/**
 * Created by Ankita
 */
public class LoginTest extends Utility {


        @Before
        public void openBrowser() {
            String baseUrl = "https://demo.nopcommerce.com/";
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }

        @Test
        public void userShouldNavigateToLoginPageSuccessFully() throws InterruptedException {
            Thread.sleep(3000);
            clickOnElement(By.xpath("//a[@class='ico-login']"));
            String expectedResult = "Welcome, Please Sign In!";
            String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
            Assert.assertEquals(expectedResult, actualResult);
        }

        @Test
        public void userShouldLoginSuccessfully() throws InterruptedException {
            clickOnElement(By.xpath("//a[@class='ico-login']"));
            Thread.sleep(3000);
            sendTextToElement(By.id("Email"),"alpha1@gmail.com");
            sendTextToElement(By.id("Password"),"Tiger123");
            Thread.sleep(3000);
            clickOnElement(By.xpath("//input[@class=\"button-1 login-button\"]"));
            String expectedResult = "Welcome to our store";
            String actualResult = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
            Assert.assertEquals(expectedResult, actualResult);

        }

        @After
        public void browserClosing() {
            driver.quit();
        }

    }
