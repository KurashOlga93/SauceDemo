package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By CART_BUDGE = By.xpath("//*[@data-test='shopping-cart-badge']");

    public CartPage openCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    public String checkCartBudgeNumber() {
        return driver.findElement(CART_BUDGE).getText();
    }
}