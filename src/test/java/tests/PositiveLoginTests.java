package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import navigation.ApplicationURLs;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {

        DriverUtils.navigateToPage(ApplicationURLs.LOGIN_URL);

        LandingPage landingPage = new LandingPage();
        boolean isBannerAfterLoginDisplayed = landingPage
            .clickOnEnterStoreLink()
            .clickOnSignInLink()
            .typeIntoUserNameField("j2ee")
            .typeIntoPasswordField("j2ee")
            .clickOnLoginButton()
            .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);
    }

}