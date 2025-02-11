package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Remove products from cart and check that products does not exist")
    public void removeProductFromCart(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductsToCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_ONESIE);
        headerPage.openCart();
        cartPage.removeProductsFromCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_ONESIE);
        Assert.assertTrue(cartPage.itemsDoesNotExistInCart());
    }

    @Test(description = "Add product to cart and click Continue. Check the next page exist")
    public void continueCheckout(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductsToCart(SAUCE_LABS_BIKE_LIGHT);
        headerPage.openCart();
        cartPage.clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE1_URL);
    }

    @Test(description = "Add product to cart and check price")
    public void checkProductPriceInCartTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductsToCart(SAUCE_LABS_BIKE_LIGHT);
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BIKE_LIGHT), "$9.99");
    }

    @Test(description = "Add two product and check quantity in cart")
    public void checkQuantityTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductsToCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BACKPACK);
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductQuantityInCart(), 2);
    }
}