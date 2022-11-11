package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class BasicLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void basicLocatorsTest() {
        driver.get(ReadProperties.getUrl());

        // Find webElement by ID
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());

        // Find webElement by Name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        // Find webElement by TagName
        driver.findElement(By.tagName("login-button")).click();

    } @Test
    public void basicLocatorsTest_2() {
        driver.get(ReadProperties.getUrl());

        // Find webElement by linkText
        driver.findElement(By.tagName("add-to-cart-sauce-labs-backpack")).click();

        // Find webElement by className
        driver.findElement(By.className("shopping_cart_badge")).click();

        driver.findElement(By.className("inventory_item_price")).click();

        // Find webElement by linkText
        driver.findElement(By.partialLinkText("your password?")).click();

    }
}
