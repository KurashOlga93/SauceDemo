package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(description = "Add product to cart and check name and price in cart")
    public void addProductToCartTest(){
        productSteps.loginAndAddProductToCart(USERNAME, PASSWORD, SAUCE_LABS_BACKPACK);
        cartSteps.openCartAndWaitForPageOpened();
        softAssert.assertEquals(cartPage.getProductName(SAUCE_LABS_BACKPACK), SAUCE_LABS_BACKPACK);
        softAssert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
        softAssert.assertAll();
    }

    @Test(description = "Add two products to cart and check number on cart icon")
    public void addTwoProductsToCartTest(){
        productSteps.loginAndAddProductToCart(USERNAME, PASSWORD, SAUCE_LABS_BOLT_T_SHIRT, TEST_ALL_THE_THINGS_T_SHIRT_RED);
        Assert.assertEquals(headerPage.checkCartBudgeNumber(), "2");
    }

    @Test(description = "Check that Add to cart button displayed")
    public void isAddToCartButtonDisplayedTest(){
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_FLEECE_JACKET));
    }

    @Test(description = "Add product to cart and check remove button displayed")
    public void isRemoveButtonDisplayedTest(){
        productSteps.loginAndAddProductToCart(USERNAME, PASSWORD, SAUCE_LABS_FLEECE_JACKET);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_FLEECE_JACKET));
    }
}
