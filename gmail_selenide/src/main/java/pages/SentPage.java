package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.NoSuchElementException;
import static com.codeborne.selenide.Selenide.$$;

public class SentPage {
    private final ElementsCollection allSentMails = $$(By.xpath("//div[text() = 'To: ']//ancestor::tr[@role = 'row']"));

    public int mailCounts(){
        int mailCounts = 0;
        try {
                allSentMails.get(0).shouldBe(Condition.visible, Duration.ofSeconds(30));
                 mailCounts = allSentMails.size();
            }
           catch (NoSuchElementException exception) { return mailCounts;}

        return mailCounts;
    }
}
