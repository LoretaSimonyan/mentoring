package org.mobile.testing.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.mobile.testing.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public BasePage returnPage(){
        return this;
    }
}
