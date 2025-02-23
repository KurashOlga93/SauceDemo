package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(description = "Add product to cart and check name and price in cart")
    public void addProductToCartTest(){
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                //.waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_BACKPACK);
        headerPage.openCart();
        softAssert.assertEquals(cartPage.getProductName(SAUCE_LABS_BACKPACK), SAUCE_LABS_BACKPACK);
        softAssert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
        softAssert.assertAll();
    }

    /**
     *
     */
    @Test(description = "Add three products to cart and check number on cart icon")
    public void addTwoProductsToCartTest(){
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_FLEECE_JACKET, SAUCE_LABS_BOLT_T_SHIRT, TEST_ALL_THE_THINGS_T_SHIRT_RED);
        Assert.assertEquals(headerPage.checkCartBudgeNumber(), "3");
    }

    @Test(description = "Check that Add to cart button displayed")
    public void isAddToCartButtonDisplayedTest(){
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_FLEECE_JACKET));
    }

    @Test(description = "Add product to cart and check remove button displayed")
    public void isRemoveButtonDisplayedTest(){
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_FLEECE_JACKET);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_FLEECE_JACKET));
    }
}
