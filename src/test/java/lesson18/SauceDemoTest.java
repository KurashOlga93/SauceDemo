package lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest {

    @Test
    public void checkingProductInCart() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.linkText("Sauce Labs Backpack")).click();
        driver.findElement(By.name("add-to-cart")).click();
        driver.findElement(By.xpath("//*[@data-test='shopping-cart-link']")).click();
        String actualProductName = driver.findElement(By.xpath("//*[@data-test='inventory-item-name']")).getText();
        String actualProductPrice = driver.findElement(By.xpath("//*[@data-test='inventory-item-price']")).getText();
        Assert.assertEquals(actualProductName, "Sauce Labs Backpack");
        Assert.assertEquals(actualProductPrice, "$29.99");
    }
}
