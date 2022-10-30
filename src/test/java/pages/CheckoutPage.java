package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
    }

       private final static String pagePath = "checkout-step-two.html";

        // Блок описания селекторов для элементов
        private final By headerTitleLabelLocator = By.xpath("//div[summary_info(text(), 'All Projects')]");


        public CheckoutPage checkoutPage;

        // Блок инициализации страницы
        public CheckoutPage(WebDriver driver) {
            super(driver);

            checkoutPage = new CheckoutPage(driver);
        }

        @Override
        protected By getPageIdentifier(By SummaryInfolabelLocator) {
            return SummaryInfolabelLocator;
        }

        public void openPageByUrl() {
            super.openPageByUrl(pagePath);
        }

        // Блок атомарных методов
        public WebElement getSummaryInfoLabel() { return driver.findElement(SummaryInfolabelLocator); }

        public boolean isSummaryInfoLabelDisplayed() { return getSummaryInfoLabel().isDisplayed();}
    }

}
