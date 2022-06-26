package macChecker;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CheckMacOpenedTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = "http://webprizma.ru:49175/wd/hub/";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void checkMacOpened() {
        open("http://gogov.ru/vkusno-i-tochka/krasnodar");
        $$("div.gu-data h3").first().shouldHave(Condition.text("Рестораны в Краснодаре"));
        $$("tr")
                .findBy(Condition.text("Краснодарский край, г. Краснодар, ул. им. Артюшкова В.Д., д. 2"))
                .shouldHave(Condition.text("закрыт"));
    }
}
