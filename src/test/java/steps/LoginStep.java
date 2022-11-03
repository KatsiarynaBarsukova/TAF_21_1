package steps;

import io.qameta.allure.Step;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    public void login(String email, String psw) {
        loginPage.setEmail(email);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    @Step
    public DashboardPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return page(DashboardPage.class);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return page(LoginPage.class);
    }
}
