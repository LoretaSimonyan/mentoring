package org.mobile.testing.app.release.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ReleaseBasePage{

    @AndroidFindBy(accessibility = "loginPageSignInButton")
    private MobileElement signInButton;

    @AndroidFindBy (accessibility = "loginPageEmailInput")
    private MobileElement loginFiled;

    @AndroidFindBy(accessibility = "loginPagePasswordInput")
    private MobileElement passwordFiled;

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void enterLogin(String login){

        loginFiled.sendKeys(login);
    }

    public void enterPassword(String password){

        passwordFiled.sendKeys(password);
    }

}
