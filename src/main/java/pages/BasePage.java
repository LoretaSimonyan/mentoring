package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

public abstract class BasePage {
    Waits waits;
    WebDriver driver;

     BasePage(WebDriver driver, Waits waits){
        this.driver = driver;
        this.waits = waits;
    }

     void waitAndClick(WebElement webElement) {
        waits.waitElementToBeClickableByWebElement(webElement);
        webElement.click();
    }

    void waitAndClick(By by, WebDriver driver) {
        waits.waitElementToBeClickableByLocator(by);
        driver.findElement(by).click();
    }

     void waitAndSendKeys(WebElement webElement, String text){
        waits.waitElementToBeClickableByWebElement(webElement);
        webElement.sendKeys(text);
    }

     String waitAndGetText(WebElement webElement){
        waits.waitElementVisibility(webElement);
        return webElement.getText();
    }
    String waitAndGetText(By by){
         waits.waitElementVisibility(by);
         return this.driver.findElement(by).getText();
    }

}
