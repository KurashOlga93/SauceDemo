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
    Waiter waiter = new Waiter();
    WebDriver driver = new ChromeDriver();

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened (String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        Waiter.waitForPageOpened(driver, LOGIN);
        loginPage.login(username, password);
        return this;
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(user);
        return this;
    }
}
