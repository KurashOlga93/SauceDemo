package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

@Log4j2
public class CheckoutOverviewPage extends HeaderPage {

    public static final By FINISH_BUTTON = By.id("finish");
    public static final By SUCCESS_TEXT = By.xpath("//*[@data-test='complete-header']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage waitForCheckoutOverviewPageOpened() {
        Waiter.waitForPageOpened(driver, FINISH_BUTTON, 15);
        log.info("Wait for checkout overview page opened");
        return this;
    }

    /**
     * Click finish button.
     */
    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }

    /**
     * Get success text string.
     *
     * @return the string
     */
    public String getSuccessText() {
        String successText = driver.findElement(SUCCESS_TEXT).getText();
        log.info("Success text is: '{}'", successText);
        return successText;
    }
}
