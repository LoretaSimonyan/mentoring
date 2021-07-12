package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

public class LoginEmailPage extends BasePage {

    private final String nextButtonLocator = "//div[@id='identifierNext']";

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailFiled;

    @FindBy(xpath = nextButtonLocator)
    private WebElement nextButton;

    PropertiesReader userProperties = new PropertiesReader();

    public LoginPasswordPage enterEmail() {
        waitAndSendKeys(emailFiled, userProperties.getUserEmail());
        nextButton.click();
        return new LoginPasswordPage();
    }
}
