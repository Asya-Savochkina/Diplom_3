package pom;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConstructorPage extends BasePage{
    //раздел конструктора "Булки"
    private final By bunsSection = By.xpath("//span[text()='Булки']");
    //раздел конструктора "Соусы"
    private final By saucesSection = By.xpath("//span[text()='Соусы']");
    //раздел конструктора "Начинки"
    private final By toppingsSection = By.xpath("//span[text()='Начинки']");
    //активный раздел конструктора
    private final By activeSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
    //заголовок "Соберите бургер"
    private final By makeYourBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");

    public ConstructorPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("Клик на раздел Булки")
    public void clickBunsSection() {
        webDriver.findElement(bunsSection).click();
    }

    @Step("Клик на раздел Соусы")
    public void clickSaucesSection() {
        webDriver.findElement(saucesSection).click();
    }

    @Step("Клик на раздел Начинки")
    public void clickToppingsSection() {
        webDriver.findElement(toppingsSection).click();
    }

    public void checkMakeYourBurgerIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(makeYourBurgerHeader).isDisplayed());
    }

    public String getTextFromActiveSection() {
        return webDriver.findElement(activeSection).getText();
    }
}
