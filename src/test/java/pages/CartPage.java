package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";

        // Блок описания селекторов для элементов
    private final By headerSecondaryContainerLocator = By.xpath("//div[span.title(text(), 'All Projects')]");

    // Блок инициализации страницы
    public CartPage(WebDriver driver) throws Exception {
        super(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return headerSecondaryContainerLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    // Блок атомарных методов
    public WebElement getHeaderSecondaryContainer() { return driver.findElement(headerSecondaryContainerLocator); }


    public boolean isHeaderSecondaryContainer() { return getHeaderSecondaryContainer().isDisplayed(); }

}