package pom;
import org.junit.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage{

    //кнопка раздела "Личный кабинет"
    private final By personalAccountBottom = By.xpath("//p[text()='Личный Кабинет']");
    //кнопка "Войти в аккаунт"
    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    //кнопка "Войти"
    private final By loginBottom = By.xpath(".//button[(text()='Войти')]");
    //кнопка "Зарегистрироваться"
    private final By regBottom = By.linkText("Зарегистрироваться");
    //кнопка "Восстановить пароль"
    private final By forgotPasswordBottom = By.linkText("Восстановить пароль");
    //поле ввода email для восстановления пароля
    private final By forgotPasswordEmailField = By.name("name");
    //кнопка "Восстановить" для восстановления пароля
    private final By restorePasswordBottom = By.linkText("Восстановить");
    //кнопка "Выход" в личном кабинете
    private final By exitBottom =  By.xpath("//button[text()='Выход']");
    //поле ввода "email"
    private final By emailField = By.xpath("//input[@name='name']");
    //поле ввода "Password"
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    //Заголовок Вход
    private final By entryHeader = By.xpath("//h2[text()='Вход']");
    //кнопка раздела "Конструктор"
    private final By constructorBottom = By.linkText("Конструктор");
    //лого Stellar Burger
    private final By stellarBurgerLogo = By.className("AppHeader_header__logo__2D0X2");
    public final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";

    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        webDriver.get(MAIN_URL);
    }

    public void clickPersonalAccountBottom() {
        webDriver.findElement(personalAccountBottom).click();
    }

    public void clickRegBottom() {
        webDriver.findElement(regBottom).click();
    }

    public void clickLoginBottom() {
        webDriver.findElement(loginBottom).click();
    }

    public void clickLoginAccountBottom() {
        webDriver.findElement(loginAccountButton).click();
    }

    public void clickForgotPasswordBottom() {
        webDriver.findElement(forgotPasswordBottom).click();
    }

    public void clickExitBottom() {
        webDriver.findElement(exitBottom).click();
    }

    public void clickLogo() {
        webDriver.findElement(stellarBurgerLogo).click();
    }

    public void clickConstructorBottom() {
        webDriver.findElement(constructorBottom).click();
    }

    public void setEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void checkEntryHeaderIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(entryHeader).isDisplayed());
    }

    public void setEmailForRestorePassword(String email) {webDriver.findElement(forgotPasswordEmailField).sendKeys(email); }

    public void clickRestorePasswordBottom() {
        webDriver.findElement(restorePasswordBottom).click();
    }
}
