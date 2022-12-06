package services;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import configuration.ReadProperties;

import java.time.Duration;
import java.util.List;

public class WaitsService {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsService(WebDriver driver, Duration timeout){
        this.driver=driver;
        wait=new WebDriverWait(driver,timeout);
    }
    public WaitsService(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(ReadProperties.timeout()));
    }
    public WebElement waitForVisibilityBy(By by){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitForVisibilityBy(WebElement webElement){
        return  wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public Boolean waitForElementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public WebElement fluentWaitForElement(By by){
        Wait<WebDriver> fluent=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);


        return fluent.until(driver1 -> driver.findElement(by));
    }
    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}