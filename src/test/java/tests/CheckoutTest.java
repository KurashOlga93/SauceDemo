package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends CartTest {

    @Test(description = "User puts the product in the cart, checkout and text about a successful purchase is displayed")
    public void userCheckout(){
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductsToCart(SAUCE_LABS_ONESIE);
        headerPage.openCart()
                .clickCheckoutButton()
                .userCheckout(FIRST_NAME, LAST_NAME, POSTAL_CODE)
                .clickFinishButton();
        Assert.assertEquals(checkoutOverviewPage.getSuccessText(),"Thank you for your order!");
    }
}