import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryTest {
    @Test
    void test() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[placeholder=\"Город\"]").setValue("Пермь");
        $("[name=\"name\"]").setValue("Роман Романов");
        $("[name=\"phone\"]").setValue("+79991234567");
        $("[class=\"checkbox__box\"]").click();
        $("[class=\"button__text\"]").click();


    }
}
