import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Visible;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryTest {
    String deliveryDate() {
        return LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        //находим самую близкую дату доставки. 3 дня от сегодняшнего
    }

    //WebDriverManager
//    @BeforeAll
//    static void setUpAll() {
//        WebDriverManager.chromedriver().setup();
//    }

    @Test
    void test() {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        String date = deliveryDate();
        $("[placeholder=\"Город\"]").setValue("Пермь");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME),Keys.DELETE);
        $("[data-test-id=date] input").setValue(date);
        $("[name=\"name\"]").setValue("Роман Романов");
        $("[name=\"phone\"]").setValue("+79991234567");
        $("[class=\"checkbox__box\"]").click();
        $("[class=\"button__text\"]").click();
        $("[class=\"notification__title\"]").should(visible, Duration.ofSeconds(15));
        $("[class=\"notification__content\"]").shouldHave(Condition.exactText("Встреча успешно забронирована на " + date));
    }
}
