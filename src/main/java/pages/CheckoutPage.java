package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class CheckoutPage extends HeaderPage {

    public static final By FIRST_NAME_INPUT = By.xpath("//*[@data-test='firstName']");
    public static final By LAST_NAME_INPUT = By.xpath("//*[@data-test='lastName']");
    public static final By ZIP_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage  userCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }
}