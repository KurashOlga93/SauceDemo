package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(description = "Add product to cart and check name and price in cart")
    public void addProductToCartTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart("Sauce Labs Backpack");
        headerPage.openCart();
        Assert.assertEquals(cartPage.getProductNameInCart(), SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductPriceInCart(), SAUCE_LABS_BACKPACK_PRICE);
    }

    @Test(description = "Add two products to cart and check number on cart icon")
    public void addTwoProductsToCartTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(headerPage.checkCartBudgeNumber(), "2");
    }
}
