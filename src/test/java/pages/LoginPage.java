package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания селекторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");

    // Блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() { return driver.findElement(emailInputLocator); }
    public WebElement getPswInput() { return driver.findElement(pswInputLocator); }
    public WebElement getLoginButton() { return driver.findElement(loginButtonLocator); }

    public void setEmail(String value) { getEmailInput().sendKeys(value); }
    public void setPsw(String value) { getPswInput().sendKeys(value); }
    public void clickLoginButton() { getLoginButton().click(); }

    public void loginSuccessful(String email, String psw) {
        setEmail(email);
        setPsw(psw);
        clickLoginButton();
    }
}
