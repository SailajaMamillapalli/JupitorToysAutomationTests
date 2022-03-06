package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utils.findElement;
import static Utilities.Utils.waitForElement;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //public IWebDriver driver;

    By ContactPageLink = By.cssSelector("a[href='#/contact']");

    By ShopPageLink = By.linkText("Shop");

    public ContactPage navigateToContactPage()
    {
        waitForElement(driver, ContactPageLink);
        findElement(driver, ContactPageLink).click();
        return new ContactPage(driver);
    }

    public ShoppingPage navigateToShoppingPage()
    {
        waitForElement(driver, ShopPageLink);
        findElement(driver, ShopPageLink).click();
        return new ShoppingPage(driver);
    }
}
