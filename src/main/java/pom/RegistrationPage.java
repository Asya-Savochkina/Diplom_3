package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    //поля ввода имени для регистрации
    private final By regName = By.xpath("//fieldset[1]//input");
    //поле ввода email для регистрации
    private final By regEmail = By.xpath("//fieldset[2]//input");
    //поле ввода пароля для регистрации
    private final By regPassword = By.xpath("//fieldset[3]//input");
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
        webDriver.findElement(regName).sendKeys(name);
        webDriver.findElement(regEmail).sendKeys(email);
        webDriver.findElement(regPassword).sendKeys(password);
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
