package org.mobile.testing.app.release.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class PickLanguagePage extends ReleaseBasePage {

    @AndroidFindBy(accessibility = "welcomePage1GetStarted")
    private  MobileElement continueButton;

    public PickLanguagePage clickOnContinueButton(){
        continueButton.click();
        return new PickLanguagePage();
    }
}
