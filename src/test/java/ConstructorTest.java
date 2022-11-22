import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Test;
import pom.ConstructorPage;
import pom.PersonalAccountPage;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход в раздел Булки")
    @Description("Проверяем возможность перехода между разделами, переходим в Булки")
    public void checkTransitionToBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesSection();
        constructorPage.clickBunsSection();
        constructorPage.checkBunIsDisplayed();
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    @Description("Проверяем возможность перехода между разделами, переходим в Соусы")
    public void checkTransitionToSauces() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickToppingsSection();
        constructorPage.clickSaucesSection();
        constructorPage.checkSaucesIsDisplayed();
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    @Description("Проверяем возможность перехода между разделами, переходим в Начинки")
    public void checkTransitionToToppings() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
        constructorPage.clickSaucesSection();
        constructorPage.clickToppingsSection();
        constructorPage.checkToppingIsDisplayed();
    }
}
