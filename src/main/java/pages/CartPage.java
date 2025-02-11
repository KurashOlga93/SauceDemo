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
    public static final By CHECKOUT_BUTTON = By.name("checkout");
    private static final String PRODUCT_ITEM_IN_CART = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM_IN_CART + "//button";

    public void removeProductsFromCartByNames(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        }
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public boolean itemsDoesNotExistInCart() {
        List<WebElement> itemsInCart = driver.findElements(By.xpath("//*[@class='cart_item']"));
        return itemsInCart.isEmpty();
    }

    public String getProductNameInCart() {
        return driver.findElement(PRODUCT_NAME_IN_CART).getText();
    }

    public String getProductPriceInCart() {
        return driver.findElement(PRODUCT_PRICE_IN_CART).getText();
    }
}