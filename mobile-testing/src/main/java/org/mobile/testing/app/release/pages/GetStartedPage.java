package org.mobile.testing.app.release.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GetStartedPage extends ReleaseBasePage{
    @AndroidFindBy(accessibility = "welcomePage3ContinueWithEmail")
    private MobileElement continueWithEmail;

    public void choseLoginWithEmail(){
        continueWithEmail.click();
    }
}
