package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends CartTest {

    @Test(description = "User puts the product in the cart, checkout and text about a successful purchase is displayed")
    public void userCheckout(){
        productSteps.loginAndAddProductToCart(USERNAME, PASSWORD, SAUCE_LABS_ONESIE);
        cartSteps.openCartAndClickCheckout();
        checkoutSteps.userCheckoutWithCorrectDataAndClickFinish(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        Assert.assertEquals(checkoutOverviewPage.getSuccessText(),"Thank you for your order!");
    }
}