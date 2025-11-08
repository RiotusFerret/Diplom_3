package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private boolean ifProfileIsVisible;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "Войти в аккаунт"
    private By loginButtonMainPage = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Войти в аккаунт']");

    // кнопка "Личный кабинет"
    private By personalCabinetButtonMainPage = By.xpath(".//p[text()='Личный Кабинет']");

    // раздел "Профиль" в личном кабинете
    private By profile = By.xpath(".//a[text()='Профиль']");

    // раздел "Булки" (неактивен)
    private By bunsInactive = By.xpath(".//span[text()='Булки']/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");

    // раздел "Булки" (активнен)
    private By bunsActive = By.xpath(".//span[text()='Булки']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    // раздел "Соусы" (неактивен)
    private By saucesInactive = By.xpath(".//span[text()='Соусы']/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");

    // раздел "Соусы" (активен)
    private By saucesActive = By.xpath(".//span[text()='Соусы']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    // раздел "Начинки" (неактивен)
    private By fillingsInactive = By.xpath(".//span[text()='Начинки']/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");

    // раздел "Начинки" (активен)
    private By fillingsActive = By.xpath(".//span[text()='Начинки']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    @Step("клик по кнопке 'Войти в аккаунт'")
    public void loginButtonMainPageClick() {
        driver.findElement(loginButtonMainPage).click();
    }
    @Step("клик по кнопке 'Личный кабинет'")
    public void personalCabinetButtonMainPageClick() {
        driver.findElement(personalCabinetButtonMainPage).click();
    }
    @Step("проверка наличия раздела 'Профиль' в личном кабинете")
    public boolean profileIsVisible() {
        ifProfileIsVisible = driver.findElement(profile).isEnabled();
        return ifProfileIsVisible;
    }
    @Step("клик по разделу 'Булки'")
    public void bunsInactiveClick() {
        driver.findElement(bunsInactive).click();
    }
    @Step("проверка смены класса раздела 'Булки' после клика")
    public boolean ifBunsActiveEnabled() {
    boolean ifBunsActive = driver.findElement(bunsActive).isEnabled();
    return ifBunsActive;
    }
    @Step("клик по разделу 'Соусы'")
    public void saucesInactiveClick() {
        driver.findElement(saucesInactive).click();
    }
    @Step("проверка смены класса раздела 'Соусы' после клика")
    public boolean isSaucesActiveEnabled() {
        boolean ifSaucesActive = driver.findElement(saucesActive).isEnabled();
        return ifSaucesActive;
    }
    @Step("клик по разделу 'Начинки'")
    public void fillingsInactiveClick() {
        driver.findElement(fillingsInactive).click();
    }
    @Step("проверка смены класса раздела 'Начинки' после клика")
    public boolean isFillingsActiveEnabled() {
        boolean ifFillingsActive = driver.findElement(fillingsActive).isEnabled();
        return ifFillingsActive;
    }
}
