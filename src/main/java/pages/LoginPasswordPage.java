package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;
import utils.Waits;

public class LoginPasswordPage extends BasePage{

    PropertiesReader userProperties = new PropertiesReader();
    private final String passwordLocator = "password";
    private final String nextButtonLocator = "passwordNext";

    @FindBy(id = nextButtonLocator)
    private WebElement nextButton;

    @FindBy(name = passwordLocator)
    private WebElement passwordFiled;

    public LoginPasswordPage(WebDriver driver, Waits waits) {
         super(driver,waits);
         PageFactory.initElements(driver, this);
    }

    public GmailMainPage enterPassword(){
        waitAndSendKeys(passwordFiled, userProperties.getUserPassword());
        nextButton.click();
        return new GmailMainPage(driver,waits);
    }
}
