package Tests;

import Pages.HomePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import static Utilities.Utils.getTextFromElement;

public class RegressionTests extends BaseTest {

    String firstName = "Sailaja";
    String email = "Sailaja.m04@gmail.com";
    String message = "This is Sailaja and I am submitting the form and providing feedback";

    @Test
    public void WhenFormSubmitted_AndNotAllMandatoryFieldsFilled_MandatoryErrorsAreDisplayed()
    {
        homePage = new HomePage(driver);
        contactPage = homePage.navigateToContactPage();

        contactPage.clickOnSubmitButton();

        int count = contactPage.getErrorListCount();
        assertTrue(count > 0, "Total error count must be greater than zero but it is :" + count);

        assertEquals(getTextFromElement(driver, contactPage.ForeNameError), "Forename is required");
        assertEquals(getTextFromElement(driver, contactPage.EmailError),"Email is required");
        assertEquals(getTextFromElement(driver, contactPage.MessageRequiredError), "Message is required");

        contactPage.fillAllMandatoryFields(firstName, email, message);

        int newCount = contactPage.getErrorListCount();
        assertEquals(newCount, 0, "Total error count must be zero but it is :" + newCount);
    }

    @Test
    public void FillInAndSubmitFeedbackForm_VerifySubmissionMessageIsCorrect()
    {
        homePage = new HomePage(driver);
        contactPage = homePage.navigateToContactPage();

        contactPage.fillAllMandatoryFields(firstName, email, message);
        contactPage.clickOnSubmitButton();

        assertEquals(getTextFromElement(driver, contactPage.SuccessMessage), "Thanks " + firstName + ", we appreciate your feedback.");
    }

    @Test
    public void WhenInvalidDataEnteredInToMandatoryFields_ErrorsAreDisplayed()
    {
        homePage = new HomePage(driver);
        contactPage = homePage.navigateToContactPage();

        String invalidEmail_1 = "Sailaja";
        String invalidEmail_2 = "Sailaja.m04@gmail";
        String invalidEmail_3 = "Sailaja1213@aaasa.comSailaja";
        String invalidEmail_4 = "Sailaja1213@.com";
        String invalidEmail_ErrorMessage = "Please enter a valid email";

        contactPage.fillEmailField(invalidEmail_1);
        assertEquals(getTextFromElement(driver, contactPage.EmailError), invalidEmail_ErrorMessage);

        contactPage.fillEmailField(invalidEmail_2);
        assertEquals(getTextFromElement(driver, contactPage.EmailError), invalidEmail_ErrorMessage);

        contactPage.fillEmailField(invalidEmail_3);
        assertEquals(getTextFromElement(driver, contactPage.EmailError),invalidEmail_ErrorMessage);

        contactPage.fillEmailField(invalidEmail_4);
        assertEquals(getTextFromElement(driver, contactPage.EmailError), invalidEmail_ErrorMessage);
    }

    @Test
    public void WhenVariousItemsAddedToCart_VerifyItemsAreAddedSuccessfully()
    {
        homePage = new HomePage(driver);
        shoppingPage = homePage.navigateToShoppingPage();

        shoppingPage.AddItemToCart(shoppingPage.FunnyCow);
        shoppingPage.AddItemToCart(shoppingPage.FunnyCow);
        shoppingPage.AddItemToCart(shoppingPage.FluffyBunny);
        shoppingPage.AddItemToCart(shoppingPage.StuffedFrog);

        cartPage = shoppingPage.ClickOnCart();
        cartPage.GetTextForVariousItemsInCart();
        assertEquals(cartPage.Item1, "Funny Cow");
        assertEquals(cartPage.Item2, "Fluffy Bunny");
    }
}
