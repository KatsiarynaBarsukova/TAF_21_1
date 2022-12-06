package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class ActionsTest extends BaseTest {

    @Test
    public void contextMenuTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement targetBox = driver.findElement(By.id("hot-spot"));
        actions
                .moveToElement(targetBox)
                .contextClick()
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("You selected a context menu"));
        alert.accept();
    }
    @Test
    public void dynamicControlsTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove = wait.waitForVisibilityBy(driver.findElement(By.xpath("//*[text()='Remove']")));
        actions
                .moveToElement(remove)
                .click()
                .build()
                .perform();
        Assert.assertTrue(wait.waitForVisibilityBy(By.id("message")).getText().equals("It's gone!"));
    }

    @Test
    public void dynamicControlsTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        WebElement input = driver.findElement((By.cssSelector("[type='text']")));
        Assert.assertTrue(input.isDisplayed());
        WebElement cliclkElement = wait.waitForVisibilityBy(driver.findElement(By.cssSelector("[onclick='swapInput()']")));
        Assert.assertTrue(cliclkElement.isDisplayed());
        actions
                .moveToElement(cliclkElement)
                .click()
                .build()
                .perform();
        Assert.assertTrue(wait.waitForVisibilityBy(By.id("message")).getText().equals("It's enabled!"));
        Assert.assertTrue(cliclkElement.isEnabled());
    }
    @Test
    public void upploaTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement faildUpload = driver.findElement(By.id("file-upload"));
        String pathToFile = this.getClass().getClassLoader().getResource("test.jpg").getPath().substring(1).replace("%20", " ");
        faildUpload.sendKeys(pathToFile);
        faildUpload.submit();
        Thread.sleep(200);
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("File Uploaded!"));
    }
}