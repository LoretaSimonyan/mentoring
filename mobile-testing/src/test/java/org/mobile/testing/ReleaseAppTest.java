package org.mobile.testing;

import org.mobile.testing.app.release.pages.GetStartedPage;
import org.mobile.testing.app.release.pages.LoginPage;
import org.mobile.testing.app.release.pages.PickLanguagePage;
import org.mobile.testing.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReleaseAppTest extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {
        PickLanguagePage pickLanguagePage = new PickLanguagePage();
        pickLanguagePage.clickOnContinueButton().clickOnContinueButton().clickOnContinueButton();

        GetStartedPage getStartedPage = new GetStartedPage();
        getStartedPage.choseLoginWithEmail();
        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin("fasio@gvhj");
        loginPage.enterPassword("ajovns");
        loginPage.clickOnSignInButton();
        Assert.assertTrue(DriverManager.getDriver().getPageSource().contains("Enter valid email and password"));
    }
}
