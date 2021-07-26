package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.NoSuchElementException;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class SentPage {
    private final ElementsCollection allSentMails = $$(By.xpath("//div[text() = 'To: ']//ancestor::tr[@role = 'row']"));

    public int mailCounts(){
        int mailCounts = 0;
        try {
                 allSentMails.shouldBe(sizeGreaterThan(0),Duration.ofSeconds(30));
                 mailCounts = allSentMails.size();
            }
           catch (NoSuchElementException exception) { return mailCounts;}

        return mailCounts;
    }
}
