import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

import static constants.URLs.HOME_PAGE;

public class ConstructorTests extends BaseTest {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Смена класса раздела 'Булки' при выборе")
    public void bunsTest() {
        driver.get(HOME_PAGE);
        mainPageObj.saucesInactiveClick();
        mainPageObj.bunsInactiveClick();
        Assert.assertTrue(mainPageObj.ifBunsActiveEnabled());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Смена класса раздела 'Соусы' при выборе")
    public void saucesTest() {
        driver.get(HOME_PAGE);
        mainPageObj.saucesInactiveClick();
        Assert.assertTrue(mainPageObj.isSaucesActiveEnabled());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Смена класса раздела 'Начинки' при выборе")
    public void fillingsTest() {
        driver.get(HOME_PAGE);
        mainPageObj.fillingsInactiveClick();
        Assert.assertTrue(mainPageObj.isFillingsActiveEnabled());
    }
}
