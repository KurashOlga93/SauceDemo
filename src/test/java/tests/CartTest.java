package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @DataProvider(name = "products")
    public Object[][] productsAndPrices() {
        return new Object[][]{
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"}
        };
    }

    @Test(description = "Remove products from cart and check that products does not exist")
    public void removeProductFromCart() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_ONESIE);
        headerPage.openCart()
                .removeProductsFromCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_ONESIE);
        Assert.assertTrue(cartPage.itemsDoesNotExistInCart());
    }

    @Test(description = "Add product to cart and click Continue. Check the next page exist")
    public void continueCheckout() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_BIKE_LIGHT);
        headerPage.openCart()
                .clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE1_URL);
    }

    @Test(dataProvider = "products", groups = "products", description = "Add product to cart and check price")
    public void checkProductPriceInCartTest(String productName, String price) {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                //.waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductsToCart(productName);
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductPrice(productName), price);
    }

    @Test(description = "Add two product and check quantity in cart")
    public void checkQuantityTest() {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BACKPACK);
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductQuantityInCart(), 2);
    }
}