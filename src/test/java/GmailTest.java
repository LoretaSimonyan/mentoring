import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.PropertiesReader;
import utils.RandomData;
import utils.Waits;

public class GmailTest {
    WebDriver driver;
    Waits waits;
    SoftAssert softAssert;
    LoginEmailPage loginEmailPage;
    GmailMainPage gmailMainPage;
    SentPage sentPage;
    MailCreatingPage mailCreatingPage;
    DraftPage draftPage;
    PropertiesReader propertiesReader = new PropertiesReader();
    private final String mailSubjectText = RandomData.randomStringGenerator(10);
    private final String mailBodyText = RandomData.randomStringGenerator(20);
    int sentMailsBeforeSendinNewMail;
    int draftsQuantityAfterCreatingNewMail;

    @BeforeClass
    public void testSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        waits = new Waits(driver);
        loginEmailPage = new LoginEmailPage(driver,waits);
        gmailMainPage = new GmailMainPage(driver,waits);
        sentPage = new SentPage(driver,waits);
        mailCreatingPage = new MailCreatingPage(driver,waits);
        draftPage = new DraftPage(driver,waits);
    }

    @Test()
    public void loginTest() {
        loginEmailPage.enterEmail();
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver,waits);
        loginPasswordPage.enterPassword();
        Assert.assertTrue(gmailMainPage.isInGmailPage(), "It's not Gmail main page");
    }

    @Test(priority = 1)
    public void createMailAndSaveInDrafts() {
        gmailMainPage.openSentMails();
        sentMailsBeforeSendinNewMail = sentPage.getSentMailsCount();
        int draftsQuantityBeforeCreatingNewMail = gmailMainPage.getDraftsQuantity();
        gmailMainPage.clickOnComposeButton();
        mailCreatingPage.createNewMail(mailSubjectText, mailBodyText);
        mailCreatingPage.clickOnSetSaveAndCloseButton();
        draftsQuantityAfterCreatingNewMail = gmailMainPage.getDraftsQuantity();
        Assert.assertEquals(draftsQuantityAfterCreatingNewMail - 1, draftsQuantityBeforeCreatingNewMail, "The message isn't saved in drafts");
    }

    @Test(priority = 2)
    public void verifyMailContentTest() {
        gmailMainPage.openDraftsPage();
        draftPage.openLastMailFromDrafts();
        softAssert = new SoftAssert();
        softAssert.assertEquals(mailSubjectText, mailCreatingPage.getTextFromSubjectFiled(), "Subjects are different");
        softAssert.assertEquals(mailBodyText, mailCreatingPage.getTextFromMailBody(), "Actual body are different from Expected");
        softAssert.assertEquals(propertiesReader.getOtherUserEmail(), mailCreatingPage.getTextFromSendToFiled(), "Users whom mails was sent are different");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void sentMailTest() {
        mailCreatingPage.sendMail();
        int draftsQuantityAfterSendingMail = gmailMainPage.getDraftsQuantity();
        Assert.assertEquals(draftsQuantityAfterSendingMail, draftsQuantityAfterCreatingNewMail - 1, "After sending mail, mail isn't disappeared from drafts");
        gmailMainPage.openSentMails();
        int sentMailsAfterSendingNewMail = sentPage.getSentMailsCount();
        Assert.assertEquals(sentMailsBeforeSendinNewMail + 1, sentMailsAfterSendingNewMail, "Sent mail isn't in Sent folder");


    }

    @AfterClass
    public void tearDown() {
        gmailMainPage.signOut();
        driver.quit();
    }
}
