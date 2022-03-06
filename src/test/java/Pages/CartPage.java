package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utilities.Utils.findElements;
import static Utilities.Utils.waitForElements;

public class CartPage extends BasePage
{
    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public String Item1;
    public String Item2;
    public By ItemsList = By.cssSelector("tr[class='cart-item ng-scope'] td:nth-child(1)");

    public void GetTextForVariousItemsInCart()
    {
        waitForElements(driver, ItemsList);
        List<WebElement> CartItemList = findElements(driver, ItemsList);
        Item1 = CartItemList.get(0).getText();
        Item2 = CartItemList.get(1).getText();
    }
}
