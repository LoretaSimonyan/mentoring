import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GmailMainPage;
import pages.LoginEmailPage;
import pages.OpenedMailPage;
import utils.PropertiesReader;
import utils.RandomData;

import static com.codeborne.selenide.Selenide.open;

public class GmailTest {
    PropertiesReader propertiesReader = new PropertiesReader();
    GmailMainPage gmailMainPage;
    User currentUser;
    User userToSent;
    private final String mailSubjectText = RandomData.randomStringGenerator(10);
    private final String mailBodyText = RandomData.randomStringGenerator(20);


    @BeforeMethod
    public void login() {
                 currentUser = new User.UserBuilder()
                .userEmail(propertiesReader.getUserEmail())
                .password(propertiesReader.getUserPassword())
                .firstName(propertiesReader.getUserName())
                .lastName(propertiesReader.getUserLastName())
                .build();
        open(propertiesReader.getBaseURL());
        LoginEmailPage loginEmailPage = new LoginEmailPage();
                gmailMainPage = loginEmailPage
                .enterEmail(currentUser)
                .enterPassword(currentUser)
                .isInGmailMainPage();
    }

    @Test()
    public void sentEmailTest() {
        userToSent = new User.UserBuilder()
                .userEmail(propertiesReader.getOtherUserEmail())
                .build();
        int mailsCountBeforeSendingMail =
                gmailMainPage
                        .openSentPage()
                        .mailCounts();
        int inboxQuantityBeforeSendingMail =
                gmailMainPage
                        .openInboxPage()
                        .mailCountsInInbox();

                gmailMainPage
                        .clickOnComposeButton()
                        .filSentToFilled(currentUser)
                        .filSubjectFiled(mailSubjectText)
                        .filMailBodyFiled(mailBodyText)
                        .clickOnSendButton();

        Assert.assertEquals(gmailMainPage.openSentPage().mailCounts(), mailsCountBeforeSendingMail + 1, "Quantity isn't changed after sending mail");

        Assert.assertEquals(gmailMainPage.openInboxPage().mailCountsInInbox(), inboxQuantityBeforeSendingMail + 1, "Quantity in Inbox isn't increased");
        SoftAssert softAssert = new SoftAssert();
        OpenedMailPage openedMailPage =
                gmailMainPage
                        .openInboxPage()
                        .openLastMailFromInbox();

        softAssert.assertEquals(mailBodyText, openedMailPage.getMailBodyText());
        softAssert.assertEquals(mailSubjectText, openedMailPage.getMailSubjectText());
        softAssert.assertEquals(currentUser.getFirstName() + " " + currentUser.getLastName(), openedMailPage.getMailSenderText());
        softAssert.assertAll();
    }
}
