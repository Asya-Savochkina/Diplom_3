package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    //поле ввода "Имя"
    private final By regNameField = By.name("name");
    //поле ввода "Email"
    private final By regEmailField = By.name("name");
    //поле ввода "Пароль"
    private final By regPasswordField = By.name("Пароль");
    //кнопка "Зарегистрироваться"
    private final By regAccountButton = By.xpath(".//button[(text()='Зарегистрироваться')]");
    //кнопка "Войти"
    private final By regLoginButton = By.xpath(".//button[(@class = 'Auth_link__1fOlj']");

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }

    public void setRegNameField(String name) {
        webDriver.findElement(regNameField).sendKeys(name);
    }

    public void setRegEmailField(String email) {
        webDriver.findElement(regEmailField).sendKeys(email);
    }

    public void setRegPasswordField(String password) {
        webDriver.findElement(regPasswordField).sendKeys(password);
    }

    public void clickRegAccountButton() {
        webDriver.findElement(regAccountButton).click();
    }

    public void clickRegLoginButton() {
        webDriver.findElement(regLoginButton).click();
    }

    public void regDataField(String name, String email, String password) {
        setRegNameField(name);
        setRegEmailField(email);
        setRegPasswordField(password);
    }
}
