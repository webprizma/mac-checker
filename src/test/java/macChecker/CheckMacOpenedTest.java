package macChecker;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class CheckMacOpenedTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void checkMacOpened() {
        Selenide.open("https://gogov.ru/vkusno-i-tochka/krasnodar");
        $$("tr")
                .findBy(Condition.text("Краснодарский край, г. Краснодар, ул. им. Артюшкова В.Д., д. 2"))
                .scrollTo().shouldHave(Condition.text("открыт"));
    }
}
