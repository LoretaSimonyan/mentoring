package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GmailMainPage {

    private String gmailMainPageIdentifierXpath = "//a[@title = 'Gmail' and @class = 'gb_ke gb_pc gb_ie']";
    private SelenideElement sentButton = $(By.xpath("//div[@data-tooltip = 'Sent']"));
    private SelenideElement inboxButton = $(By.xpath("//a[text() = 'Inbox']"));
    private SelenideElement composeButton = $(By.xpath("//div[text() = 'Compose']"));

    public  GmailMainPage  isInGmailMainPage(){
        $(By.xpath(gmailMainPageIdentifierXpath))
                .shouldBe(Condition.visible);
//                .shouldHave(Condition.text("Gmail"));
        return this;
    }

    public SentPage openSentPage() {
        sleep(30);
        sentButton.click();
        return new SentPage();
    }

    public InboxPage openInboxPage(){
        sleep(30);
        inboxButton.click();
        return  new InboxPage();
    }

    public MailCreatingPage clickOnComposeButton(){
        sleep(30);
        composeButton.click();
        return new MailCreatingPage();
    }
}
