package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Ankita
 */
public class Books extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
   // private WebDriver driver;
    @Before
    public void openBrowser(){
       // String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void verifyUserShouldNevigateToBookPage(){
        clickOnElement(By.linkText("Books"));
        String expectedText = "Books";
        String actualText =getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected message on Page : " + expectedText);

        System.out.println("Actual message on Page : " + actualText);
    }



    @Test
    public void booksPage() throws InterruptedException {
        clickOnElement(By.linkText("Books"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        Thread.sleep(2000);

        ArrayList<String> getList = new ArrayList<>();//creating the array list for obtain the elements from webpage
        List<WebElement> elementList = driver.findElements(By.tagName("h2"));//finding the elements by tag name
        for (WebElement Links : elementList) {
            getList.add(Links.getText());
        }
        System.out.println("Obtained Product List :" + getList);
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(getList);
        Collections.sort(sortedList);
        Assert.assertEquals(getList, sortedList);

    }



    @Test
    public void wishList() throws InterruptedException
    {
        clickOnElement(By.linkText("Books"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        Thread.sleep(3000);
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedResult, actualResult);

    }


    @After
    public void closeBrowser() {
        driver.close();
    }
}
