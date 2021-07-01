package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

import java.util.List;

public class SentPage extends BasePage {

    private final String allSentMailsLocator = "//div[text() = 'To: ']//ancestor::tr[@role = 'row']";
    @FindBy(xpath = allSentMailsLocator)
    private List<WebElement> allSentMails;

    @FindBy(xpath = "//td[@class = 'TC']")
    private WebElement noMailMessage;


    public SentPage(WebDriver driver, Waits waits) {
        super(driver, waits);
        PageFactory.initElements(driver, this);
    }

    public int getSentMailsCount() {
       try {
           waits.waitElementVisibility(By.xpath(allSentMailsLocator));
       }
       catch (TimeoutException exception){
           return 0;
       }
        return allSentMails.size();
    }

    public String getNoMailMassageText(){
        return waitAndGetText(noMailMessage);
    }
}
