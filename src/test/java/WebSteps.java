import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://ru.wikipedia.org");

        return this;
    }

    @Step("Переходим по ссылке в заголовке")
    public WebSteps followLinkInHeader() {
        $(".mw-headline").$(byText("Википедию")).click();

        return this;
    }

    @Step("Проверяем название статьи")
    public WebSteps checkTitle() {
        $(".mw-page-title-main").shouldHave(text("Википедия"));

        return this;
    }
}
