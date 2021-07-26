package pages;

import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPasswordPage {

    private final SelenideElement passwordFiled= $(By.name("password"));
    private final SelenideElement nextButton = $(By.id("passwordNext"));

    public GmailMainPage enterPassword(User user){
        passwordFiled.setValue(user.getUserPassword());
        nextButton.click();
        return new GmailMainPage();
    }

}
