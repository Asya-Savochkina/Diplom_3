import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected static final WebDriver webDriver = new ChromeDriver();

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void clearData() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage)webDriver).getSessionStorage().clear();
        ((WebStorage)webDriver).getLocalStorage().clear();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
