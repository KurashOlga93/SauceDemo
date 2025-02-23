package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends HeaderPage {

    public static final By FINISH_BUTTON = By.id("finish");
    public static final By SUCCESS_TEXT = By.xpath("//*[@data-test='complete-header']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click finish button.
     */
    public void clickFinishButton(){
        waiter.waitForPageOpened(driver, FINISH_BUTTON, 15);
        driver.findElement(FINISH_BUTTON).click();
    }

    /**
     * Get success text string.
     *
     * @return the string
     */
    public String getSuccessText(){
        return driver.findElement(SUCCESS_TEXT).getText();
    }
}
