package steps;

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
    public ProductSteps loginAndAddProductToCart(String username, String password, String productName) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(username, password);
        productsPage.addProductsToCart(productName);
        return this;
    }
}
