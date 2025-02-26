package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HeaderPage;

public class CartSteps {

    private HeaderPage headerPage;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
    }

    @Step("Open cart and wait for page opened")
    public CartSteps openCartAndWaitForPageOpened () {
        headerPage.openCart();
        cartPage.waitForCartPageOpened();
        return this;
    }

    @Step("Open cart, wait for page opened and click Checkout")
    public CartSteps openCartAndClickCheckout () {
        headerPage.openCart();
        cartPage.waitForCartPageOpened()
                .clickCheckoutButton();
        return this;
    }

    @Step("Open cart and remove products from cart")
    public CartSteps openCartAndRemoveProductsFromCart (String... productNames) {
        headerPage.openCart();
        cartPage.waitForCartPageOpened()
                .removeProductsFromCart(productNames);
        return this;
    }
}
