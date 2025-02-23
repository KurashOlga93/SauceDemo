package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage {

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String PRODUCT_NAME = PRODUCT_ITEM + "//*[@class=\"inventory_item_name\"]";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";
    private static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";
    public static final By CHECKOUT_BUTTON = By.name("checkout");
    private static final By CART_ITEM = By.xpath("//*[@class='cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openCartPage(String url) {
        driver.get(url);
        return this;
    }

    public CartPage removeProductsFromCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        }
        return this;
    }

    public CheckoutPage clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }

    public boolean itemsDoesNotExistInCart() {
        List<WebElement> itemsInCart = driver.findElements(CART_ITEM);
        return itemsInCart.isEmpty();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
    }

    public Integer getProductQuantityInCart() {
        return driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
    }

    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }
}