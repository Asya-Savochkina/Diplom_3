package PageObject;

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

    public void setRegNameField(String name) {
        webDriver.findElement(regNameField).sendKeys(name);
    }

    public void setRegEmailField(String name) {
        webDriver.findElement(regEmailField).sendKeys(name);
    }

    public void setRegPasswordField(String name) {
        webDriver.findElement(regPasswordField).sendKeys(name);
    }

    public void clickRegAccountButton() {
        webDriver.findElement(regAccountButton).click();
    }

    public void clickRegLoginButton() {
        webDriver.findElement(regLoginButton).click();
    }
}
