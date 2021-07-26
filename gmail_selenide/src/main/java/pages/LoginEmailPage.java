package pages;

import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginEmailPage {

    private final SelenideElement userEmailFiled= $(By.id("identifierId"));
    private final SelenideElement nextButton = $(By.id("identifierNext"));

    public LoginPasswordPage enterEmail(User user){
        userEmailFiled.setValue(user.getUserEmail());
        nextButton.click();
        return  new LoginPasswordPage();
    }
}
