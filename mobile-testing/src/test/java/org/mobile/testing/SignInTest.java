package org.mobile.testing;

import org.mobile.testing.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    @Test
    public void loginWithInvalidCredentials(){
        SignInPage signInPage = new SignInPage();
        signInPage.clickOnSignInButton();
        signInPage.enterLogin("nejol");
        signInPage.enterPassword("jfkel");
        signInPage.clickOnSignInButton();
        Assert.assertTrue(signInPage.validateErrorMessage(), "error message isn't appeared");
    }
}
