package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GmailMainPage {

    private final String gmailMainPageIdentifierXpath = "//a[@title = 'Gmail' and @class = 'gb_ke gb_pc gb_ie']";
    private final SelenideElement sentButton = $(By.xpath("//div[@data-tooltip = 'Sent']"));
    private final SelenideElement inboxButton = $(By.xpath("//a[text() = 'Inbox']"));
    private final SelenideElement composeButton = $(By.xpath("//div[text() = 'Compose']"));

    public  GmailMainPage  isInGmailMainPage(){
                 $(By.xpath(gmailMainPageIdentifierXpath))
                .shouldBe(Condition.visible);
        return this;
    }

    public SentPage openSentPage() {
        sentButton.click();
        return new SentPage();
    }

    public InboxPage openInboxPage(){
        inboxButton.click();
        return  new InboxPage();
    }

    public MailCreatingPage clickOnComposeButton(){
        composeButton.click();
        return new MailCreatingPage();
    }
}
