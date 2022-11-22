package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ожидание видимости указанного элемента")
    public WebElement waitForElement(WebElement element) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Ожидание в секундах")
    public void waitForSeconds(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
