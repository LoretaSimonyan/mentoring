import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.PropertiesReader;
import utils.RandomData;
import utils.Waits;

public class GmailTest {
    WebDriver driver;
    Waits waits;
    SoftAssert softAssert;
    GmailMainPage gmailMainPage;
    PropertiesReader propertiesReader = new PropertiesReader();
    private final String mailSubjectText = RandomData.randomStringGenerator(10);
    private final String mailBodyText = RandomData.randomStringGenerator(20);
    private final String mailSenderName = "User Useryan";
    int sentMailsBeforeSendinNewMail;

    @BeforeMethod()
    public void login() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        waits = new Waits(driver);
        LoginEmailPage loginEmailPage = new LoginEmailPage(driver, waits);
        LoginPasswordPage loginPasswordPage = loginEmailPage.enterEmail();
        gmailMainPage = loginPasswordPage.enterPassword();
        Assert.assertTrue(gmailMainPage.isInGmailPage(), "It's not Gmail main page");
    }

    @Test(priority = 0)
    public void sentEmailTest() {
        SentPage sentPage = gmailMainPage.openSentMails();
        sentMailsBeforeSendinNewMail = sentPage.getSentMailsCount();
        int draftsQuantityBeforeCreatingNewMail = gmailMainPage.getDraftsQuantity();
        MailCreatingPage mailCreatingPage = gmailMainPage.clickOnComposeButton();
        mailCreatingPage.createNewMail(mailSubjectText, mailBodyText);
        mailCreatingPage.clickOnSetSaveAndCloseButton();
        int draftsQuantityAfterCreatingNewMail = gmailMainPage.getDraftsQuantity();
        Assert.assertEquals(draftsQuantityAfterCreatingNewMail - 1, draftsQuantityBeforeCreatingNewMail, "The message isn't saved in drafts");

        DraftPage draftPage = gmailMainPage.openDraftsPage();
        draftPage.openLastMailFromDrafts();
        softAssert = new SoftAssert();
        softAssert.assertEquals(mailBodyText, mailCreatingPage.getTextFromMailBody(), "Actual body are different from Expected");
        softAssert.assertEquals(mailSubjectText, mailCreatingPage.getTextFromSubjectFiled(), "Subjects are different");
        softAssert.assertEquals(propertiesReader.getOtherUserEmail(), mailCreatingPage.getTextFromSendToFiled(), "Users whom mails was sent are different");
        softAssert.assertAll();

        mailCreatingPage.sendMail();
        int draftsQuantityAfterSendingMail = gmailMainPage.getDraftsQuantity();
        Assert.assertEquals(draftsQuantityAfterSendingMail, draftsQuantityAfterCreatingNewMail - 1, "After sending mail, mail isn't disappeared from drafts");
        gmailMainPage.openSentMails();
        int sentMailsAfterSendingNewMail = sentPage.getSentMailsCount();
        Assert.assertEquals(sentMailsBeforeSendinNewMail + 1, sentMailsAfterSendingNewMail, "Sent mail isn't in Sent folder");
    }

    @Test(priority = 1)
    public void receiveAndCheckEmail() {
        SentPage sentPage = gmailMainPage.openSentMails();
        int mailsCountBeforeSendingMail = sentPage.getSentMailsCount();
        InboxPage inboxPage = gmailMainPage.openInboxPage();
        int inboxQuantityBeforeSendingMail = inboxPage.quantityOfMailsInInbox();
        MailCreatingPage mailCreatingPage = gmailMainPage.clickOnComposeButton();
        mailCreatingPage.sendEmailToYourself(mailSubjectText, mailBodyText);
        mailCreatingPage.sendMail();
        gmailMainPage.openSentMails();
        Assert.assertEquals(sentPage.getSentMailsCount(),mailsCountBeforeSendingMail+1, "Quantity isn't changed after sending mail");
        gmailMainPage.openInboxPage();
        Assert.assertEquals(inboxPage.quantityOfMailsInInbox(),inboxQuantityBeforeSendingMail+1,"Quantity in Inbox isn't increased");

        OpenedMailPage openedMailPage = inboxPage.openLastMailFromInbox();
        softAssert = new SoftAssert();
        softAssert.assertEquals(mailBodyText, openedMailPage.getOpenedMailBodyText());
        softAssert.assertEquals(mailSubjectText,openedMailPage.getOpenedMailSubjectText());
        softAssert.assertEquals(mailSenderName,openedMailPage.getOpenedMailSenderText());
        softAssert.assertAll();

    }

    @Test(priority = 1)
    public void deleteAllSentEmails(){
        SentPage sentPage = gmailMainPage.openSentMails();
        Assert.assertNotEquals(sentPage.getSentMailsCount(),0, "Sent page is empty");
        gmailMainPage.selectAllMails();
        Assert.assertTrue(gmailMainPage.isAllMailsAreSelected(),"All mails aren't selected after clicking 'select all' checkbox");
        gmailMainPage.clickOnDeleteButton();
        softAssert = new SoftAssert();
        softAssert.assertEquals(sentPage.getNoMailMassageText(),"No sent messages! Send one now!","Massage for empty sent page isn't correct");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        gmailMainPage.signOut();
        driver.quit();
    }
}
