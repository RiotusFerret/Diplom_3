import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static constants.URLs.HOME_PAGE;

public class ConstructorTests extends BaseTest {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void bunsTest() {
        driver.get(HOME_PAGE);
        mainPageObj.saucesInactiveClick();
        mainPageObj.bunsInactiveClick();
        Assert.assertTrue(mainPageObj.ifBunsActiveEnabled()); // смена класса раздела при выборе
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void saucesTest() {
        driver.get(HOME_PAGE);
        mainPageObj.saucesInactiveClick();
        Assert.assertTrue(mainPageObj.isSaucesActiveEnabled()); // смена класса раздела при выборе
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void fillingsTest() {
        driver.get(HOME_PAGE);
        mainPageObj.fillingsInactiveClick();
        Assert.assertTrue(mainPageObj.isFillingsActiveEnabled()); // смена класса раздела при выборе
    }
}
