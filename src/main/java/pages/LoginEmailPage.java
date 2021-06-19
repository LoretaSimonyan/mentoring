package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;
import utils.Waits;

public class LoginEmailPage {
    private final WebDriver driver;
    private  Waits waits;
    private final String nextButtonLocator = "//div[@id='identifierNext']";

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailFiled;

    @FindBy(xpath = nextButtonLocator)
    private WebElement nextButton;

    PropertiesReader userProperties = new PropertiesReader();

    public LoginEmailPage(WebDriver driver, Waits waits) {
        this.driver = driver;
        this.waits = waits;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(){
        waits.waitElementToBeClickableByLocator(By.xpath(nextButtonLocator));
        emailFiled.sendKeys(userProperties.getUserEmail());
        nextButton.click();
    }
}
