package org.mobile.testing.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.mobile.testing.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public BasePage returnPage(){
        return this;
    }
}
