package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HangoutsPage extends BasePage {

    // @FindBy(xpath = "//div[text() = 'Share your status...']/following-sibling::div")
    @FindBy(xpath = "//div[@class = 'vE dQ editable']")
    private WebElement shareStatusFiled;


    @FindBy(xpath = "//img[@class = 'xU zc-Sf']")
    private WebElement hangoutsImage;

    @FindBy(xpath = "//iframe[@class = 'a1i']")
    private WebElement userFrame;

    @FindBy(xpath = "//button[text() = 'Sign out of Hangouts']")
    private WebElement signOutOfHangoutsButton;

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    public void shareYourStatus(String status) {
        switchToFrame(userFrame);
        sendKeys(shareStatusFiled, status + Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void signOutOfHangouts() {
        switchToFrame(userFrame);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", signOutOfHangoutsButton);
        signOutOfHangoutsButton.click();
        driver.switchTo().defaultContent();
    }
}
