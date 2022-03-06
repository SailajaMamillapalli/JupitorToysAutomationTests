package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utilities.Utils.*;

public class ContactPage extends BasePage
{
    public ContactPage(WebDriver driver)
    {
        super(driver);
    }

    public By SubmitButton = By.cssSelector("a[class='btn-contact btn btn-primary']");
    public By Errors = By.cssSelector("span[class='help-inline ng-scope']");
    public By FirstName = By.id("forename");
    public By Email = By.id("email");
    public By Message = By.id("message");
    public By SuccessMessage = By.cssSelector("div[class='alert alert-success']");
    public By ForeNameError = By.id("forename-err");
    public By EmailError = By.id("email-err");
    public By MessageRequiredError = By.id("message-err");

    public void clickOnSubmitButton()
    {
        waitForElement(driver, SubmitButton);
        findElement(driver, SubmitButton).click();
    }

    public int getErrorListCount()
    {
        List<WebElement> ErrList = findElements(driver, Errors);
        return ErrList.size();
    }

    public void fillAllMandatoryFields(String forename, String email, String message)
    {
        findElement(driver, FirstName).sendKeys(forename);
        findElement(driver, Email).sendKeys(email);
        findElement(driver, Message).sendKeys(message);
    }

    public void fillEmailField(String email)
    {
        findElement(driver, Email).clear();
        findElement(driver, Email).sendKeys(email);
    }
}
