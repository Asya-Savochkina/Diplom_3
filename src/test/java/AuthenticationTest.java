import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import model.CreateTheUserRequest;
import model.UserAuthRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.ConstructorPage;
import pom.LoginPage;
import pom.PersonalAccountPage;
import pom.RegistrationPage;

import static model.CreateTheUserRequest.getUserAllRequiredField;

public class AuthenticationTest extends BaseTest {

    CreateTheUserRequest createTheUserRequest = new CreateTheUserRequest();
    RegAndAuthForUser regAndAuthForUser = new RegAndAuthForUser();
    RegistrationPage registrationPage;
    PersonalAccountPage personalAccountPage;
    ConstructorPage constructorPage;

    LoginPage loginPage;

    @Before
    public void setUp() {
        registrationPage = new RegistrationPage(webDriver);
        personalAccountPage = new PersonalAccountPage(webDriver);
        constructorPage = new ConstructorPage(webDriver);
        loginPage = new LoginPage(webDriver);
        createTheUserRequest = getUserAllRequiredField();
        regAndAuthForUser.regNewUser(createTheUserRequest);
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт")
    @Description("Проверяем вариант залогиниться через кнопку Войти в аккаунт на главной")
    public void checkLogInToAccountWithButtonOnMainPage() {
        loginPage.clickLoginAccountBottom();
        loginPage.setEmailField(createTheUserRequest.getEmail());
        loginPage.setPasswordField(createTheUserRequest.getPassword());
        loginPage.clickLoginBottom();
        constructorPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Вход по кнопке Личный кабинет")
    @Description("Проверяем вариант залогиниться через кнопку Личный кабинет на главной")
    public void checkLogInToPersonalAccountButtonOnMainPage() {
        loginPage.clickPersonalAccountBottom();
        loginPage.setEmailField(createTheUserRequest.getEmail());
        loginPage.setPasswordField(createTheUserRequest.getPassword());
        loginPage.clickLoginBottom();
        constructorPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Вход по кнопке Войти на странице регистрации")
    @Description("Проверяем вариант залогиниться через кнопку Войти на странице регистрации")
    public void checkLogInFromRegistrationPage() {
        loginPage.clickPersonalAccountBottom();
        loginPage.clickRegBottom();
        loginPage.clickLoginInRegBottom();
        loginPage.setEmailField(createTheUserRequest.getEmail());
        loginPage.setPasswordField(createTheUserRequest.getPassword());
        loginPage.clickLoginBottom();
        constructorPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Вход по кнопке Войти на странице восстановления пароля")
    @Description("Проверяем вариант залогиниться через кнопку Войти на странице восстановления пароля")
    public void checkLogInFromForgotPasswordPage() {
        loginPage.clickPersonalAccountBottom();
        loginPage.clickForgotPasswordBottom();
        loginPage.clickLoginInRegBottom();
        loginPage.setEmailField(createTheUserRequest.getEmail());
        loginPage.setPasswordField(createTheUserRequest.getPassword());
        loginPage.clickLoginBottom();
        constructorPage.checkMakeYourBurgerIsDisplayed();
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
