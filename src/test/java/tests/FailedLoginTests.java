package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import navigation.ApplicationURLs;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
        " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {

        DriverUtils.navigateToPage(ApplicationURLs.LOGIN_URL);

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink()
            .clickOnSignInLink()
            .typeIntoUserNameField("NotExistingLogin")
            .typeIntoPasswordField("NotProperPassword")
            .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

}