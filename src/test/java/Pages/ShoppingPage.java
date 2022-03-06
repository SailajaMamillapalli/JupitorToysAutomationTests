package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utils.findElement;
import static Utilities.Utils.waitForElement;

public class ShoppingPage extends BasePage
{
    public ShoppingPage(WebDriver driver)
    {
        super(driver);
    }

    public By FunnyCow = By.cssSelector("li[id='product-6'] a");
    public By FluffyBunny = By.cssSelector("li[id='product-4'] a");
    public By StuffedFrog = By.cssSelector("li[id='product-2'] a");
    public By CartItems = By.cssSelector("li[id='nav-cart'] span");

    public void AddItemToCart(By by)
    {
        waitForElement(driver, by);
        findElement(driver, by).click();
    }

    public CartPage ClickOnCart()
    {
        waitForElement(driver, CartItems);
        findElement(driver, CartItems).click();
        return new CartPage(driver);
    }
}
