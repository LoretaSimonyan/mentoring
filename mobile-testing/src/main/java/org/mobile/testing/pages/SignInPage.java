package org.mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

public class SignInPage extends BasePage{
    Actions action;

    @FindBy(id = "com.epam.connect.android:id/tvLoginButton")
    private MobileElement signInButton;

    @FindBy(id = "com.epam.connect.android:id/etLoginField")
    private MobileElement loginFiled;

    @FindBy(id = "com.epam.connect.android:id/etPasswordField")
    private MobileElement passwordFiled;

    @FindBy(id = "com.epam.connect.android:id/tvSnackbarTitle")
    private List<MobileElement> errorMessage;

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void enterLogin(String login){

        loginFiled.sendKeys(login);
    }

    public void enterPassword(String password){

       passwordFiled.sendKeys(password);
    }

    public boolean validateErrorMessage(){
        if (errorMessage.size() > 0){
            return true;
        }
        return false;
    }

}
