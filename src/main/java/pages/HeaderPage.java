package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By CART_BUDGE = By.xpath("//*[@data-test='shopping-cart-badge']");

    /**
     * Open cart cart page.
     *
     * @return the cart page
     */
    public CartPage openCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    /**
     * Check cart budge number string.
     *
     * @return the string
     */
    public String checkCartBudgeNumber() {
        return driver.findElement(CART_BUDGE).getText();
    }
}