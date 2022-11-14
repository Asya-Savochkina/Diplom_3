package PageObject;

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
    private final By forgetPasswordBottom = By.linkText("Восстановить пароль");
    //поле ввода "Email"
    private final By emailField = By.name("name");
    //поле ввода "Password"
    private final By passwordField = By.name("Пароль");
    //кнопка раздела "Конструктор"
    private final By constructorBottom = By.linkText("Конструктор");
    //лого Stellar Burger
    private final By stellarBurgerLogo = By.className("AppHeader_header__logo__2D0X2");

    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
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

    public void clickForgetPasswordBottom() {
        webDriver.findElement(forgetPasswordBottom).click();
    }

    public void clickLogo() {
        webDriver.findElement(stellarBurgerLogo).click();
    }

    public void clickConstructorBottom() {
        webDriver.findElement(constructorBottom).click();
    }

    public void setEmailField(String name) {
        webDriver.findElement(emailField).sendKeys(name);
    }

    public void setPasswordField(String name) {
        webDriver.findElement(passwordField).sendKeys(name);
    }
}
