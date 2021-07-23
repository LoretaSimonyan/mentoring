package pages;
import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MailCreatingPage {

    private SelenideElement sentToFiled = $(By.name("to"));
    private SelenideElement subjectFiled =  $(By.name("subjectbox"));
    private SelenideElement mailBodyFiled = $(By.xpath("//div[@aria-label = 'Message Body']"));
    private SelenideElement sendButton = $(By.xpath("//div[text()='Send']"));

    public MailCreatingPage filSentToFilled(User user){
        sentToFiled.setValue(user.getUserEmail());
        return this;
    }

    public MailCreatingPage filSubjectFiled(String text){
        subjectFiled.setValue(text);
        return this;
    }

    public MailCreatingPage filMailBodyFiled(String text){
        mailBodyFiled.setValue(text);
        return this;
    }

    public MailCreatingPage clickOnSendButton(){
        sendButton.click();
        return this;
    }
}
