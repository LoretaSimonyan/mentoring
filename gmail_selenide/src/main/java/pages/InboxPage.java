package pages;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class InboxPage {
    private final ElementsCollection allMailsInInbox = $$(By.xpath("//div[@role = 'main' ]//tr[@role = 'row']"));

    public int mailCountsInInbox() {
        int mailCounts = 0;
        try {
            allMailsInInbox.shouldBe(sizeGreaterThan(0),Duration.ofSeconds(30));
            mailCounts = allMailsInInbox.size();
        }
        catch (NoSuchElementException exception) { return mailCounts;}
        return mailCounts;
    }

    public OpenedMailPage openLastMailFromInbox(){
        allMailsInInbox.get(0).click();
        return new OpenedMailPage();
    }
}
