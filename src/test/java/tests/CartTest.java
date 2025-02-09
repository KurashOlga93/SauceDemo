package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Remove product from cart and check that remove button does not exist")
    public void removeProductFromCart(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart("Sauce Labs Bike Light");
        headerPage.openCart();
        cartPage.removeProductFromCart();
        Assert.assertTrue(cartPage.removeButtonExist());
    }

    @Test(description = "Add product to cart and click Continue. Check the next page exist")
    public void continueCheckout(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart("Sauce Labs Bike Light");
        headerPage.openCart();
        cartPage.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE1_URL);
    }
}