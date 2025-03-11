package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiters.Waiter;

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

    /**
     * Wait for cart page opened cart page.
     *
     * @return the cart page
     */
    public CartPage waitForCartPageOpened() {
        Waiter.waitForPageOpened(driver, CHECKOUT_BUTTON, 15);
        return this;
    }

    /**
     * Open cart page.
     *
     * @param url the url
     * @return the cart page
     */
    public CartPage openCartPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Remove products from cart.
     *
     * @param productNames the product names
     * @return the cart page
     */
    public CartPage removeProductsFromCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        }
        return this;
    }

    /**
     * Click checkout button checkout page.
     *
     * @return the checkout page
     */
    public CheckoutPage clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }

    /**
     * Items does not exist in cart boolean.
     *
     * @return the boolean
     */
    public boolean itemsDoesNotExistInCart() {
        List<WebElement> itemsInCart = driver.findElements(CART_ITEM);
        return itemsInCart.isEmpty();
    }

    /**
     * Gets product price.
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    /**
     * Gets product name.
     *
     * @param productName the product name
     * @return the product name
     */
    public String getProductName(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
    }

    /**
     * Gets product quantity in cart.
     *
     * @return the product quantity in cart
     */
    public Integer getProductQuantityInCart() {
        return driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }
}