package Tests;

import Pages.CartPage;
import Pages.ContactPage;
import Pages.HomePage;
import Pages.ShoppingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public HomePage homePage;
    public ContactPage contactPage;
    public ShoppingPage shoppingPage;
    public CartPage cartPage;

    @BeforeMethod
    public void SetUp(Method method)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String ApplicationUrl = "https://jupiter.cloud.planittesting.com/";
        driver.navigate().to(ApplicationUrl);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("Starting test : -------" + method.getName() + "-------");
    }

    @AfterMethod
    public void TearDown(ITestResult result)
    {
        if(ITestResult.FAILURE == result.getStatus())
        {
            try
            {
                TakesScreenshot ts=(TakesScreenshot)driver;

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                try{
                    FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
                    System.out.println("Screenshot taken");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }

        driver.quit();

        System.out.println("Test case: -----" +  result.getMethod().getMethodName() + ": execution completed ------");
    }
}
