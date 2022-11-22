package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    //поля ввода для регистрации
    private final By registerForm = By.xpath("//input[@class='text input__textfield text_type_main-default']");
    //Ошибка при вводе короткого пароля
    private final By shortPasswordError = By.xpath("//p[text()='Некорректный пароль']");
    //кнопка "Зарегистрироваться"
    private final By regAccountButton = By.xpath("//button[text()='Зарегистрироваться']");
    //кнопка "Войти"
    private final By regLoginButton = By.xpath("//button[text()='Войти']");
    //Заголовок Вход
    private final By entryHeader = By.xpath("//h2[text()='Вход']");

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }

    public void clickRegAccountButton() {
        webDriver.findElement(regAccountButton).click();
    }


    public void clickRegLoginButton() {
        webDriver.findElement(regLoginButton).click();
    }

    public void regDataField(String name, String email, String password) {
        webDriver.findElements(registerForm).get(0).sendKeys(name);
        webDriver.findElements(registerForm).get(1).sendKeys(email);
        webDriver.findElements(registerForm).get(2).sendKeys(password);
    }

    public String getTextOfShortPasswordError() {
        return webDriver.findElement(shortPasswordError).getText();
    }

    public void checkEntryHeaderIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(entryHeader).isDisplayed());
    }

    public void checkLoginButtonIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(regLoginButton).isDisplayed());
    }
}
