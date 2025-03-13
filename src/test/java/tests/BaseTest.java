package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pages.*;
import steps.CartSteps;
import steps.CheckoutSteps;
import steps.LoginSteps;
import steps.ProductSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    SoftAssert softAssert;
    LoginPageFactory loginPageFactory;
    ProductSteps productSteps;
    LoginSteps loginSteps;
    CartSteps cartSteps;
    CheckoutSteps checkoutSteps;


    /**
     * This is initialisation of pages
     */
    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        softAssert = new SoftAssert();
        iTestContext.setAttribute("driver", driver);
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        loginSteps = new LoginSteps(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
        checkoutSteps = new CheckoutSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}