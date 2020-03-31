package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ankita
 */
public class Computers extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
   // private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToComputerPage() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Computers')]"));
        String expectedResult = "Computers";
        String actualResult = getTextFromElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Computers')]"));
        Assert.assertEquals(expectedResult, actualResult);


    }

    @Test
    public void verifyUserShouldAddProductInToCart() throws InterruptedException {
        Thread.sleep(3000);
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Computers')]"));
        clickOnElement(By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Build your own computer')]"));
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-1']"));
        clickOnElement(By.xpath("//p[@class='content']"));

        String expectedResult = "The product has been added to your shopping cart";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void closingBrowser() {
        driver.close();
    }
}
