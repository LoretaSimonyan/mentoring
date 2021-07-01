package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;
import utils.Waits;

public class MailCreatingPage extends BasePage{
    PropertiesReader userProperties;

    private final String sendToLocator = "to";
    @FindBy(name = sendToLocator)
    private WebElement sendToFiled;

    private final String subjectFiledLocator = "subjectbox";
    @FindBy(name = subjectFiledLocator)
    private WebElement subjectFiled;

    private final String sendButtonLocator = "//div[text()='Send']";
    @FindBy(xpath = sendButtonLocator)
    private WebElement sendButton;

    private final String mailBodyLocator = "//div[@aria-label = 'Message Body']";
    @FindBy(xpath = mailBodyLocator)
    private WebElement mailBodyFiled;

    @FindBy(xpath = "//img[@data-tooltip='Save & close']")
    private WebElement saveAndCloseButton;

    private final String sendToTextLocator = "//div[@class = 'oL aDm az9']";
    @FindBy(xpath = sendToTextLocator)
    private WebElement sendToText;

    private final String mailSubjectTextLocator= "//div[@class = 'aYF']//span";
    @FindBy(xpath = mailSubjectTextLocator)
    private WebElement mailSubjectText;

    public MailCreatingPage(WebDriver driver, Waits waits) {
        super(driver, waits);
        PageFactory.initElements(driver, this);
    }

    public void clickOnSetSaveAndCloseButton() {
        saveAndCloseButton.click();
    }

    public void createNewMail(String subjectText, String bodyText) {
        waits.waitElementToBeClickableByLocator(By.xpath(sendButtonLocator));
        userProperties = new PropertiesReader();
        sendToFiled.sendKeys(getOtherUserEmail());
        subjectFiled.sendKeys(subjectText);
        mailBodyFiled.sendKeys(bodyText);
    }

    public void sendEmailToYourself(String subjectText, String bodyText){
        waits.waitElementToBeClickableByLocator(By.xpath(sendButtonLocator));
        userProperties = new PropertiesReader();
        sendToFiled.sendKeys(userProperties.getUserEmail()+"@gmail.com");
        subjectFiled.sendKeys(subjectText);
        mailBodyFiled.sendKeys(bodyText);
    }

    public String getTextFromMailBody() {
        return waitAndGetText(mailBodyFiled);
    }

    public String getTextFromSendToFiled() {
        return waitAndGetText(sendToText);
    }

    public String getTextFromSubjectFiled() {
        waits.waitElementVisibility(By.xpath(mailSubjectTextLocator));
        return mailSubjectText.getText();
    }

    public String getOtherUserEmail() {
        userProperties = new PropertiesReader();
        return userProperties.getOtherUserEmail();
    }

    public void sendMail() {
        waits.waitElementToBeClickableByLocator(By.xpath(sendButtonLocator));
        sendButton.click();
    }
}
