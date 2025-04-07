package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {

    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "Login with empty username field and check validation.")
    public void loginWithEmptyUsernameTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "Login with empty password field and check validation.")
    public void loginWithEmptyPasswordTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "Login with empty fields and check validation.")
    public void loginWithEmptyFieldsTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "Login with invalid data in fields and check validation.")
    public void loginWithIncorrectFieldsTest(){
        loginSteps.loginAndWaitForPageOpened(userWithIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }

    /*@Test
    public void loginWithoutPageFactory(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }
    */

//    @Test
//    public void loginWithPageFactory(){
//        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButton = loginPageFactory.getAddButton();
//        addButton.click();
//        WebElement deleteButton = loginPageFactory.getDeleteButton();
//        deleteButton.click();
//
//        addButton.click();
//        deleteButton.click();
//    }
}