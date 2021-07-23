package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;
import static com.codeborne.selenide.Selenide.*;

public class InboxPage {
    private final ElementsCollection allMailsInInbox = $$(By.xpath("//div[@role = 'main' ]//tr[@role = 'row']"));

    public int mailCountsInInbox() {
        int mailCounts = 0;
        if (allMailsInInbox.size() > 0) {
            mailCounts = allMailsInInbox.size();
        }
        else return mailCounts;

        return mailCounts;
    }

    public OpenedMailPage openLastMailFromInbox(){
        allMailsInInbox.get(0).click();
        return new OpenedMailPage();
    }
}
