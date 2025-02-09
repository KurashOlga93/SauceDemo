package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By PRODUCT_NAME_IN_CART = By.xpath("//*[@data-test='inventory-item-name']");
    public static final By PRODUCT_PRICE_IN_CART = By.xpath("//*[@data-test='inventory-item-price']");
    public static final By REMOVE_BUTTON = By.xpath("//*[@class='btn btn_secondary btn_small cart_button']");
    public static final By CHECKOUT_BUTTON = By.name("checkout");


    public void removeProductFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public boolean removeButtonExist() {
        List<WebElement> removeButton = driver.findElements(REMOVE_BUTTON);
        return removeButton.isEmpty();
    }

    public String getProductNameInCart() {
        return driver.findElement(PRODUCT_NAME_IN_CART).getText();
    }

    public String getProductPriceInCart() {
        return driver.findElement(PRODUCT_PRICE_IN_CART).getText();
    }
}