package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    Boolean loginFormIsEnabled;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "Зарегистрироваться"
    private By registerButtonLoginPage = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[text()='Зарегистрироваться']");
    public void registerButtonLoginPageClick() {
        driver.findElement(registerButtonLoginPage).click();
    }

    // проверка успешности регистрации
    private By authForm = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']");
    public boolean enterHeaderVisibilityCheck() {
        loginFormIsEnabled = driver.findElement(authForm).isEnabled();
        return loginFormIsEnabled;
    }

    // поле "Email"
    private By emailAuthField = By.xpath(".//label[text()='Email']/parent::div/input");
    public void emailAuthFieldInput(String email) {
        driver.findElement(emailAuthField).sendKeys(email);
    }
    // поле "Пароль"
    private By passwordAuthField = By.xpath(".//label[text()='Пароль']/parent::div/input");
    public void passwordAuthFieldInput(String password) {
        driver.findElement(passwordAuthField).sendKeys(password);
    }

    // кнопка "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }
    public boolean ifLoginButtonIsVisible() {
        boolean loginButtonIsVisible = driver.findElement(loginButton).isDisplayed();
        return loginButtonIsVisible;
    }

    // кнопка "Восстановить пароль"
    private By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    public void restorePasswordButtonClick() {
        driver.findElement(restorePasswordButton).click();
    }

    // кнопка "Войти" на странице восстановления пароля
    private By loginButtonForgotPasswordPage = By.xpath(".//a[text()='Войти']");
    public void loginButtonForgotPasswordPageClick() {
        driver.findElement(loginButtonForgotPasswordPage).click();


    }
}
