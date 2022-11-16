import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Test;
import pom.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Корректная регистрация в сервисе")
    @Description("Проверяем вариант успешной регистрации, ожидаем, что после регистрации можем попасть в личный кабинет")
    public void verifyThatSuccessfulRegistrationIsPossible() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.regDataField("Mary", "mary@mail.ru", "qwerty");
        registrationPage.clickRegAccountButton();
    }
}
