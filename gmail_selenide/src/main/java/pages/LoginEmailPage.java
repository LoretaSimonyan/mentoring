package pages;

import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginEmailPage {

    private String userEmailFiledId = "identifierId";
    private String nextButtonId = "identifierNext";

    public LoginPasswordPage enterEmail(User user){
        $(By.id(userEmailFiledId)).setValue(user.getUserEmail());
        $(By.id(nextButtonId)).click();
        return  new LoginPasswordPage();
    }
}
