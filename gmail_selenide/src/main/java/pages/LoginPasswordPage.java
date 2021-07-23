package pages;

import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPasswordPage {

    private String passwordFiledName = "password";
    private String nextButtonId = "passwordNext";

    public GmailMainPage enterPassword(User user){
        $(By.name(passwordFiledName)).setValue(user.getUserPassword());
        $(By.id(nextButtonId)).click();
        return new GmailMainPage();
    }

}
