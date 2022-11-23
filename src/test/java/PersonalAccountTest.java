import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.ConstructorPage;
import pom.PersonalAccountPage;
import pom.RegistrationPage;

public class PersonalAccountTest extends BaseTest {

    private static final String MAIL = RandomStringUtils.randomAlphanumeric(5) + "@example.ru";
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(8);
    private static final String NAME = RandomStringUtils.randomAlphanumeric(5);

    @Before
    public void setUp() {
        RegAndAuthForUser regAndAuthForUser;
    }

    @Test
    @DisplayName("Переход в Личный кабинет")
    @Description("Проверяем возможность входа в Личный кабинет с главной по кнопке Личный кабинет")
    public void checkEntryToPersonalAccount() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        personalAccountPage.clickLoginAccountBottom();
        personalAccountPage.checkEntryHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Переход в Конструктор")
    @Description("Проверяем возможность перехода со страницы личного кабинета в Конструктор")
    public void checkTransitionToConstructor() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        personalAccountPage.clickLoginAccountBottom();
        personalAccountPage.clickConstructorBottom();
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Переход в Конструктор через лого")
    @Description("Проверяем возможность перехода со страницы личного кабинета через лого в Конструктор")
    public void checkTransitionLogoToConstructor() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        personalAccountPage.clickLoginAccountBottom();
        personalAccountPage.clickLogo();
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    @Description("Проверяем возможность войти в личный кабинет по кнопке Войти в аккаунт на главной")
    public void checkEntry() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        registrationPage.openRegistrationPage();
        registrationPage.regDataField( NAME, MAIL, PASSWORD);
        registrationPage.clickRegAccountButton();
        personalAccountPage.openMainPage();
        personalAccountPage.clickLoginAccountBottom();
        personalAccountPage.loginDataField(MAIL, PASSWORD);
        constructorPage.checkMakeYourBurgerIsDisplayed();
    }
}
