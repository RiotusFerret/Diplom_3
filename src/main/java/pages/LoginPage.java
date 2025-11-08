package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "Зарегистрироваться"
    private By registerButtonLoginPage = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Зарегистрироваться']");

    // поле "Email"
    private By emailAuthField = By.xpath(".//label[text()='Email']/parent::div/input");

    // поле "Пароль"
    private By passwordAuthField = By.xpath(".//label[text()='Пароль']/parent::div/input");

    // кнопка "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");

    // кнопка "Восстановить пароль"
    private By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    // кнопка "Войти" на странице восстановления пароля
    private By loginButtonForgotPasswordPage = By.xpath(".//a[text()='Войти']");

    // клик по кнопке "Зарегистрироваться"
    public void registerButtonLoginPageClick() {
        driver.findElement(registerButtonLoginPage).click();
    }
    @Step("заполнение поля 'Email'")
    public void emailAuthFieldInput(String email) {
        driver.findElement(emailAuthField).sendKeys(email);
    }
    @Step("заполнение поля 'Пароль'")
    public void passwordAuthFieldInput(String password) {
        driver.findElement(passwordAuthField).sendKeys(password);
    }
    @Step("клик по кнопке 'Войти'")
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
    @Step("проверка наличия кнопки 'Войти'")
    public boolean ifLoginButtonIsVisible() {
        boolean loginButtonIsVisible = driver.findElement(loginButton).isDisplayed();
        return loginButtonIsVisible;
    }
    @Step("клик по кнопке 'Восстановить пароль'")
    public void restorePasswordButtonClick() {
        driver.findElement(restorePasswordButton).click();
    }
    @Step("клик по кнопке 'Войти' на странице восстановления пароля")
    public void loginButtonForgotPasswordPageClick() {
        driver.findElement(loginButtonForgotPasswordPage).click();
    }
}
