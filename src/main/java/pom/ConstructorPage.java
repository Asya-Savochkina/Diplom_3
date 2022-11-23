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
    //заголовок "Соберите бургер"
    private final By makeYourBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");
    //флюорисцентная булка
    private final By fluBun = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    //фирменный соус
    private final By firmSauce = By.xpath("//img[@alt='Соус фирменный Space Sauce']");
    //начинка мясо моллюсков
    private final By shellfishMeat = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");


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

    public void checkBunIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(fluBun).isDisplayed());
    }

    public void checkSaucesIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(firmSauce).isDisplayed());
    }

    public void checkToppingIsDisplayed() {
        Assert.assertTrue(webDriver.findElement(shellfishMeat).isDisplayed());
    }
}
