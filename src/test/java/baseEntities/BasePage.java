package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) throws Exception {
        this.driver = driver;

        if (!isPageOpened()) {
            int i = 0;
            while (i < 30 && isPageOpened()) {
                Thread.sleep(1000);
            }
        }

        if (!isPageOpened()) {
            throw new Exception("Page has not been opened.");
        }
    }
    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
