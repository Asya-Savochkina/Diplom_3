package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage{

    //кнопка раздела "Личный кабинет"
    private final By personalAccountBottom = By.className("AppHeader_header__linkText__3q_va ml-2");
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
    //поле ввода "Email"
    private final By emailField = By.name("name");
    //кнопка "Выход" в личном кабинете
    private final By exitBottom = By.className("Account_button__14Yp3 text text_type_main-medium text_color_inactive");
    //поле ввода "Password"
    private final By passwordField = By.name("Пароль");
    //кнопка раздела "Конструктор"
    private final By constructorBottom = By.linkText("Конструктор");
    //лого Stellar Burger
    private final By stellarBurgerLogo = By.className("AppHeader_header__logo__2D0X2");

    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
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

    public void authDataField(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
    }

    public void setEmailForRestorePassword(String email) {webDriver.findElement(forgotPasswordEmailField).sendKeys(email); }

    public void clickRestorePasswordBottom() {
        webDriver.findElement(restorePasswordBottom).click();
    }
}
