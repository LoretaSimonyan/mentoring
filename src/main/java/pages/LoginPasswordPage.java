package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

public class LoginPasswordPage extends BasePage {

    PropertiesReader userProperties = new PropertiesReader();
    private final String passwordLocator = "password";
    private final String nextButtonLocator = "passwordNext";

    @FindBy(id = nextButtonLocator)
    private WebElement nextButton;

    @FindBy(name = passwordLocator)
    private WebElement passwordFiled;

    public GmailMainPage enterPassword() {
        waitAndSendKeys(passwordFiled, userProperties.getUserPassword());
        nextButton.click();
        return new GmailMainPage();
    }
}
