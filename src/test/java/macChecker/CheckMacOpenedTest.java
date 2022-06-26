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
    public static void beforeAll() {
        Configuration.baseUrl = "https://gogov.ru";
        Configuration.remote = "http://webprizma.ru:49175/wd/hub/";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "102";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void checkMacOpened() {
        open("/vkusno-i-tochka/krasnodar");
        $$("div.gu-data h3").first().shouldHave(Condition.text("Рестораны в Краснодаре"));
        $$("tr")
                .findBy(Condition.text("Краснодарский край, г. Краснодар, ул. им. Артюшкова В.Д., д. 2"))
                .shouldHave(Condition.text("закрыт"));
    }
}
