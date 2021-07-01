package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;
import utils.Waits;

public class LoginEmailPage extends BasePage{

    private final String nextButtonLocator = "//div[@id='identifierNext']";
   LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver,waits);

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailFiled;

    @FindBy(xpath = nextButtonLocator)
    private WebElement nextButton;

    PropertiesReader userProperties = new PropertiesReader();

    public LoginEmailPage(WebDriver driver, Waits waits) {
        super(driver,waits);
        PageFactory.initElements(driver, this);
    }

    public LoginPasswordPage enterEmail(){
        waitAndSendKeys(emailFiled, userProperties.getUserEmail());
        nextButton.click();
        return new LoginPasswordPage(driver,waits);
    }
}
