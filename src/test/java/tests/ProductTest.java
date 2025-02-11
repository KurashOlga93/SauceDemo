package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(description = "Add product to cart and check name and price in cart")
    public void addProductToCartTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductsToCart(SAUCE_LABS_BACKPACK);
        headerPage.openCart();
        softAssert.assertEquals(cartPage.getProductNameInCart(), SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductPriceInCart(), SAUCE_LABS_BACKPACK_PRICE);
    }

    @Test(description = "Add three products to cart and check number on cart icon")
    public void addTwoProductsToCartTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductsToCart(SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_BOLT_T_SHIRT, TEST_ALL_THE_THINGS_T_SHIRT_RED);
        Assert.assertEquals(headerPage.checkCartBudgeNumber(), "3");
    }
}
