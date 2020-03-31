package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Ankita
 */
public class Utility {

    public WebDriver driver;

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }


    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


    public void selectByIndexForDropDownElement(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);

    }

    public void selectByValueForDropDownElement(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByVisibleTextForDropDownElement(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }


}




