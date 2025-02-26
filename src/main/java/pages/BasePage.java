package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

abstract class BasePage implements IConstants {
    WebDriver driver;
    Waiter waiter = new Waiter();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
