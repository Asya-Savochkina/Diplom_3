import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import model.CreateTheUserRequest;
import model.UserAuthRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.PersonalAccountPage;
import pom.RegistrationPage;

import static model.CreateTheUserRequest.getUserAllRequiredField;
import static model.CreateTheUserRequest.getUserWrongPassword;

public class RegistrationTest extends BaseTest {

    CreateTheUserRequest createTheUserRequest = new CreateTheUserRequest();
    CreateTheUserRequest createTheUserWithWrongPassword = new CreateTheUserRequest();
    RegAndAuthForUser regAndAuthForUser = new RegAndAuthForUser();

    private static final String MAIL = RandomStringUtils.randomAlphanumeric(5) + "@example.ru";
    private static final String SHORT_PASSWORD = RandomStringUtils.randomAlphanumeric(2);
    private static final String NAME = RandomStringUtils.randomAlphanumeric(5);

    @Test
    @DisplayName("Корректная регистрация в сервисе")
    @Description("Проверяем вариант успешной регистрации, ожидаем, что после регистрации можем попасть в личный кабинет")
    public void verifyThatSuccessfulRegistrationIsPossible() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        createTheUserRequest = getUserAllRequiredField();
        regAndAuthForUser.regNewUser(createTheUserRequest);
        registrationPage.openRegistrationPage();
        registrationPage.regDataField( createTheUserRequest.getName(), createTheUserRequest.getEmail(), createTheUserRequest.getPassword());
        registrationPage.clickRegAccountButton();
        registrationPage.checkLoginButtonIsDisplayed();
    }

    @Test
    @DisplayName("Ввод короткого пароля ")
    @Description("Проверяем вариант ввода пароля менее 6 символов, ожидаем ошибку")
    public void verifyErrorForShortPasswordForRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        createTheUserWithWrongPassword = getUserWrongPassword();
        regAndAuthForUser.regNewUser(createTheUserWithWrongPassword);
        registrationPage.openRegistrationPage();
        registrationPage.regDataField( createTheUserWithWrongPassword.getName(), createTheUserWithWrongPassword.getEmail(), createTheUserWithWrongPassword.getPassword());
        registrationPage.clickRegAccountButton();
        Assert.assertEquals("Некорректный пароль", registrationPage.getTextOfShortPasswordError());
    }

    @After
    public void removeUser() {
        RegAndAuthForUser regAndAuthForUser = new RegAndAuthForUser();
        UserAuthRequest userAuthRequest = new UserAuthRequest(createTheUserRequest.getEmail(), createTheUserRequest.getPassword());
        Response response = regAndAuthForUser.authUser(userAuthRequest);
        String accessToken = response
                .then()
                .extract()
                .path("accessToken");

        if (accessToken != null) {
            regAndAuthForUser.removeForUser(accessToken);
        }
    }
}
