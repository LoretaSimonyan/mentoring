package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

import java.util.List;

public class GmailMainPage extends BasePage {

    private final String gmailPageIdentifierLocator = "//a[@title = 'Gmail' and @class = 'gb_ke gb_pc gb_ie']";
    @FindBy(xpath = gmailPageIdentifierLocator)
    private WebElement gmailPageIdentifier;

    @FindBy(xpath = "//div[text() = 'Compose']")
    private WebElement composeButton;

    @FindBy(xpath = "//div[@data-tooltip = 'Sent']")
    private WebElement sentButton;

    private final String draftsButtonLocator = "//div[@data-tooltip = 'Drafts']";
    @FindBy(xpath = draftsButtonLocator)
    private WebElement draftsButton;

    @FindBy(xpath = "//a[text() = 'Inbox']")
    private WebElement inboxButton;

    private final String draftsQuantityLocator = "//a[contains(text(),'Drafts')]/parent::span/following-sibling::div";
    @FindBy(xpath = draftsQuantityLocator)
    private WebElement draftsQuantity;

    @FindBy(xpath ="//a[@class = 'gb_C gb_Ma gb_h']" )
    private WebElement userButton;

    private final String signOutButtonLocator = "//a[text() = 'Sign out']";
    @FindBy(xpath = signOutButtonLocator)
    private WebElement signOutButton;

    @FindBy(xpath = "//a[text() ='Inbox']/parent::span/following-sibling::div")
    private WebElement inboxQuantity;

    private final String locatorForAllMailsCheckBox = "//div[text() = 'To: ']//ancestor::tr[@role = 'row']//div[@role = 'checkbox']";
    @FindBy(xpath = locatorForAllMailsCheckBox)
    private List<WebElement> allMailsCheckBox;

    @FindBy(xpath = "//div[@gh = 'tm']//span[@role = 'checkbox']")
    private WebElement mainCheckbox;

    @FindBy(xpath = "//div[@gh = 'tm']//div[@data-tooltip = 'Delete' ]")
    private WebElement deleteButton;

    public GmailMainPage(WebDriver driver, Waits waits) {
        super(driver,waits);
        PageFactory.initElements(driver, this);
    }

    public int getDraftsQuantity(){
        waits.waitElementToBeClickableByLocator(By.xpath(draftsQuantityLocator));
        return Integer.parseInt(draftsQuantity.getText());
    }

    public MailCreatingPage clickOnComposeButton() {
        composeButton.click();
        return  new MailCreatingPage(driver,waits);
    }

    public DraftPage openDraftsPage(){
        waitAndClick(draftsButton);
        return  new DraftPage(driver,waits);
    }

    public boolean isInGmailPage() {
        waits.waitElementVisibility(By.xpath(gmailPageIdentifierLocator));
        return gmailPageIdentifier.isDisplayed();
    }

    public SentPage openSentMails(){
        waitAndClick(sentButton);
        return  new SentPage(driver,waits);
    }

    public void signOut(){ ;
        waitAndClick(userButton);
        waitAndClick(signOutButton);
    }

    public InboxPage openInboxPage(){
        waitAndClick(inboxButton);
        return new InboxPage(driver,waits);
    }

    public int getInboxQuantity(){
       return Integer.parseInt(waitAndGetText(inboxQuantity));
    }

    public void selectAllMails() {

        mainCheckbox.click();
    }

    public boolean isAllMailsAreSelected() {
        waits.waitElementVisibility(By.xpath(locatorForAllMailsCheckBox));
        for (int i = 0; i < allMailsCheckBox.size(); ++i){
            waits.waitElementToBeClickableByWebElement(allMailsCheckBox.get(i));
            System.out.println(i);
            if(!Boolean.parseBoolean(allMailsCheckBox.get(i).getAttribute("aria-checked"))) {
                return false;
            }
        }
        return true;
    }

    public void clickOnDeleteButton(){
        waitAndClick(deleteButton);
    }
}
