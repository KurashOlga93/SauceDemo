package tests;

import constants.IConstants;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends CartTest {

    public static final By FINISH_BUTTON = By.id("finish");

    @Test(description = "User puts the product in the cart and checks out and sees a text about a successful purchase")
    public void userCheckout(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart("Sauce Labs Bike Light");
        headerPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.checkout(FIRST_NAME,LAST_NAME,POSTAL_CODE);
        Assert.assertTrue(driver.findElement(FINISH_BUTTON).isDisplayed());
        driver.findElement(FINISH_BUTTON).click();
        String successText = driver.findElement(By.xpath("//*[@data-test='complete-header']")).getText();
        Assert.assertEquals("Thank you for your order!", successText);
    }
}
