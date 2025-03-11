package steps;

import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.IConstants.LOGIN_PAGE_URL;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProductToCart(String username, String password, String... productNames) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password);
        productsPage.addProductsToCart(productNames);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProductToCart(User user, String... productNames) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user);
        productsPage.addProductsToCart(productNames);
        return this;
    }
}
