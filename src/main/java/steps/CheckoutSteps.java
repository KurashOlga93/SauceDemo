package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    public CheckoutSteps(WebDriver driver) {
        checkoutPage = new CheckoutPage(driver);
    }

    @Step("Open checkout page, fill the field and finish checkout")
    public CheckoutSteps userCheckoutWithCorrectDataAndClickFinish(String firstName, String lastName, String postalCode) {
        checkoutPage.userCheckout(firstName, lastName, postalCode)
                .waitForCheckoutOverviewPageOpened()
                .clickFinishButton();
        return this;
    }
}
