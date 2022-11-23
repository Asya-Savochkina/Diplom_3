
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import model.CreateTheUserRequest;

public class DataForReg {
    @Step("Данные для регистрации пользователя")
    public static CreateTheUserRequest getUserRequestWithCorrectData() {
        String name = RandomStringUtils.randomAlphabetic(5);
        String email = RandomStringUtils.randomAlphabetic(5) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(8);
        return new CreateTheUserRequest(name, email, password);
    }
}