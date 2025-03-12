package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

@Log4j2
public class CheckoutPage extends HeaderPage {

    public static final By FIRST_NAME_INPUT = By.xpath("//*[@data-test='firstName']");
    public static final By LAST_NAME_INPUT = By.xpath("//*[@data-test='lastName']");
    public static final By ZIP_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage waitForCheckoutPageOpened() {
        Waiter.waitForPageOpened(driver, CONTINUE_BUTTON, 15);
        log.info("Wait for checkout page opened");
        return this;
    }

    /**
     * User checkout checkout overview page.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param postalCode the postal code
     * @return the checkout overview page
     */
    public CheckoutOverviewPage userCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
        log.info("User checkout successfully");
        return new CheckoutOverviewPage(driver);
    }
}