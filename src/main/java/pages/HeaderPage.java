package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        String cartBudgeNumber = driver.findElement(CART_BUDGE).getText();
        log.info("Cart budge number is: {}", cartBudgeNumber);
        return cartBudgeNumber;
    }
}