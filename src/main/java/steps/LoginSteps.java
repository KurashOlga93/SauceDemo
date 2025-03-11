package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import waiters.Waiter;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForLoginPageOpened()
                .login(user);
        return this;
    }
}
