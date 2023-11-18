import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WikipediaTests {

    @Test
    void TitleMustContainLinkWthListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://ru.wikipedia.org");
        $(".mw-headline").$(byText("Википедию")).click();
        $(".mw-page-title-main").shouldHave(text("Википедия"));
    }

    @Test
    void TitleMustContainLinkWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://ru.wikipedia.org");
        });

        step("Переходим по ссылке в заголовке", () -> {
            $(".mw-headline").$(byText("Википедию")).click();
        });

        step("Проверяем название статьи", () -> {
            $(".mw-page-title-main").shouldHave(text("Википедия"));
        });
    }

    @Test
    @Feature("Feature")
    @Story("Story")
    @Owner("I AM")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Link", url = "https://ru.wikipedia.org")
    @DisplayName("Проверка наличия ссылки на статью 'википедия' на главной странице википедии")
    void TitleMustContainLinkWithWebSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps
                .openMainPage()
                .followLinkInHeader()
                .checkTitle();
    }
}
