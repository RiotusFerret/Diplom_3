package pages;

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
    public void loginButtonMainPageClick() {
        driver.findElement(loginButtonMainPage).click();
    }

    // кнопка "Личный кабинет"
    private By personalCabinetButtonMainPage = By.xpath(".//p[text()='Личный Кабинет']");
    public void personalCabinetButtonMainPageClick() {
        driver.findElement(personalCabinetButtonMainPage).click();
    }

    // проверка авторизации (эл-т в личном кабинете)
    private By profile = By.xpath(".//a[text()='Профиль']");
    public boolean profileIsVisible() {
        ifProfileIsVisible = driver.findElement(profile).isEnabled();
        return ifProfileIsVisible;
    }

    // раздел "Булки" (неактивен)
    private By bunsInactive = By.xpath(".//span[text()='Булки']/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    public void bunsInactiveClick() {
        driver.findElement(bunsInactive).click();
    }
    // раздел "Булки" (активнен)
    private By bunsActive = By.xpath(".//span[text()='Булки']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public boolean ifBunsActiveEnabled() {
        boolean isBunsActive = driver.findElement(bunsActive).isEnabled();
        return isBunsActive;
    }
    // раздел "Соусы" (неактивен)
    private By saucesInactive = By.xpath(".//span[text()='Соусы']/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    public void saucesInactiveClick() {
        driver.findElement(saucesInactive).click();
    }
    // раздел "Соусы" (активен)
    private By saucesActive = By.xpath(".//span[text()='Соусы']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public boolean isSaucesActiveEnabled() {
        boolean isSaucesActive = driver.findElement(saucesActive).isEnabled();
        return isSaucesActive;
    }
    // раздел "Начинки" (неактивен)
    private By fillingsInactive = By.xpath(".//span[text()='Начинки']/parent::div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    public void fillingsInactiveClick() {
        driver.findElement(fillingsInactive).click();
    }
    // раздел "Начинки" (активен)
    private By fillingsActive = By.xpath(".//span[text()='Начинки']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public boolean isFillingsActiveEnabled() {
        boolean isFillingsActive = driver.findElement(fillingsActive).isEnabled();
        return isFillingsActive;
    }}
