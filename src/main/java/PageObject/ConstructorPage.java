package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage{
    //раздел конструктора "Булки"
    private final By bunsSection = By.xpath(".//div[(text()='Булки')]");
    //раздел конструктора "Соусы"
    private final By saucesSection = By.xpath(".//div[(text()='Соусы')]");
    //раздел конструктора "Начинки"
    private final By toppingsSection = By.xpath(".//div[(text()='Начинки')]");

    public ConstructorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickBunsSection() {
        webDriver.findElement(bunsSection).click();
    }

    public void clickSaucesSection() {
        webDriver.findElement(saucesSection).click();
    }

    public void clickToppingsSection() {
        webDriver.findElement(toppingsSection).click();
    }
}
