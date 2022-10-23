package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginSuccessful(ReadProperties.username(), ReadProperties.password());

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void incorrectUsernameTest() {
        // Какие-то действия

        DashboardPage dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void incorrectPswTest() {

    }
}
