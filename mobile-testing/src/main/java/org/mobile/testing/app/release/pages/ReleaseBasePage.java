package org.mobile.testing.app.release.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.mobile.testing.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ReleaseBasePage {
    public ReleaseBasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public ReleaseBasePage returnPage(){
        return this;
    }
}
