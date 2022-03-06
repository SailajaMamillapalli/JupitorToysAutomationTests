package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utils {
    public static WebElement findElement(WebDriver driver, By by)
    {
        return driver.findElement(by);
    }

    public static List<WebElement> findElements(WebDriver driver, By by)
    {
        return driver.findElements(by);
    }

    public static void waitForElement(WebDriver driver, By by)
    {
        WebDriverWait Wait = new WebDriverWait(driver, 20);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElements(WebDriver driver, By by)
    {
        WebDriverWait Wait = new WebDriverWait(driver, 20);
        Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static String getTextFromElement(WebDriver driver, By by)
    {
        waitForElement(driver, by);
        return findElement(driver, by).getText();
    }
}
