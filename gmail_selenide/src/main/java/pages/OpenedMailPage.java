package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class OpenedMailPage {

  private final SelenideElement mailSubject = $(By.xpath("//div[text() = 'Inbox']/ancestor::div[@class = 'ha']/h2"));
  private final SelenideElement mailBody = $(By.xpath("//div/div[@dir = 'ltr']"));
  private final SelenideElement mailSender = $(By.xpath("//span[@email]/span"));

  public String getMailSubjectText(){
      return mailSubject.getText();
  }

  public String getMailBodyText(){
      return mailBody.text();
  }

  public String getMailSenderText(){
      return mailSender.getText();
  }
}
