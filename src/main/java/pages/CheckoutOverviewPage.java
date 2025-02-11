package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends HeaderPage {

    public static final By FINISH_BUTTON = By.id("finish");
    public static final By SUCCESS_TEXT = By.xpath("//*[@data-test='complete-header']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public String getSuccessText(){
        return driver.findElement(SUCCESS_TEXT).getText();
    }
}
