package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //кнопка Личный кабинет
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    //поле ввода "email"
    private final By emailField = By.xpath("//input[@name='name']");
    //поле ввода "Password"
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    //кнопка Войти на странице регистрации
    private final By loginInGegBottom = By.xpath("//a[text()='Войти']");
    //кнопка Войти
    private final By loginBottom = By.xpath("//button[text()='Войти']");
    //заголовок "Соберите бургер"
    private final By makeYourBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");
    //кнопка "Зарегистрироваться"
    private final By regBottom = By.xpath("//a[text()='Зарегистрироваться']");
    //кнопка "Восстановить пароль"
    private final By forgotPasswordBottom = By.xpath("//a[text()='Восстановить пароль']");
    //поле ввода email для восстановления пароля
    private final By forgotPasswordEmailField = By.name("name");
    //кнопка "Восстановить" для восстановления пароля
    private final By restorePasswordBottom = By.linkText("Восстановить");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLoginInRegBottom() {
        webDriver.findElement(loginInGegBottom).click();
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

    public void clickPersonalAccountBottom() {
        webDriver.findElement(personalAccountButton).click();
    }

    public void clickForgotPasswordBottom() {
        webDriver.findElement(forgotPasswordBottom).click();
    }

    public void setEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void setEmailForRestorePassword(String email) {webDriver.findElement(forgotPasswordEmailField).sendKeys(email); }

    public void clickRestorePasswordBottom() {
        webDriver.findElement(restorePasswordBottom).click();
    }
}
