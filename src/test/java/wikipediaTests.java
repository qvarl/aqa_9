import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class wikipediaTests {

    @Test
    void TitleMustContainLink() {
        open("https://ru.wikipedia.org");
        $(".mw-headline").$(byText("Википедию")).click();
        $(".mw-page-title-main").shouldHave(text("Википедия"));
    }
}
