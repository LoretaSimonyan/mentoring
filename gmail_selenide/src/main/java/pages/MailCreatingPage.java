package pages;
import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MailCreatingPage {

    private final SelenideElement sentToFiled = $(By.name("to"));
    private final SelenideElement subjectFiled =  $(By.name("subjectbox"));
    private final SelenideElement mailBodyFiled = $(By.xpath("//div[@aria-label = 'Message Body']"));
    private final SelenideElement sendButton = $(By.xpath("//div[text()='Send']"));

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

    public void clickOnSendButton(){
        sendButton.click();
    }
}
