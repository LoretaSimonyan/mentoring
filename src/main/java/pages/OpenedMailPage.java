package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

public class OpenedMailPage extends BasePage{

    @FindBy(xpath = "//div[text() = 'Inbox']/ancestor::div[@class = 'ha']/h2")
    private WebElement openedMailSubject;

    private final String openedMailBodyLocator = "//div/div[@dir = 'ltr']";
    @FindBy(xpath = openedMailBodyLocator)
    private WebElement openedMailBody;

    @FindBy(xpath = "//span[@email]/span")
    private  WebElement openedMailSender;

    public OpenedMailPage(WebDriver driver, Waits waits) {
        super(driver, waits);
        PageFactory.initElements(driver,this);
    }

    public String getOpenedMailSubjectText(){
        return waitAndGetText(openedMailSubject);
    }

    public String getOpenedMailBodyText(){
        return waitAndGetText(By.xpath(openedMailBodyLocator));
    }

    public String getOpenedMailSenderText(){
        return waitAndGetText(openedMailSender);
    }
}
