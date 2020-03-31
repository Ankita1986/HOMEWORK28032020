package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Ankita
 */
public class Electronics extends Utility {
   // private WebDriver driver;

    @Before

    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToElectronicsPage() {

        mouseHoverToElement(By.linkText("Electronics"));
        mouseHoverToElementAndClick(By.linkText("Camera & photo"));

        String expectedResult = "Camera & photo";
        String actualResult = getTextFromElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void verifyPositionOfPriceIsLowToHigh() {
        mouseHoverToElement(By.linkText("Electronics"));
        mouseHoverToElementAndClick(By.linkText("Camera & photo"));
        selectByVisibleTextForDropDownElement(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");


        List<WebElement> elements = driver.findElements(By.className("prices"));
        List<String> WebSortedPrices = elements.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> mySortedPrices = new ArrayList<>();
        for (WebElement element : elements) {
            String text = element.getText();
            mySortedPrices.add(text);
        }
        Assert.assertEquals(WebSortedPrices, mySortedPrices);
        System.out.println(mySortedPrices);

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
