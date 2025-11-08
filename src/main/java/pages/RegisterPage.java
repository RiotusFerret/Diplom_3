package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    boolean passwordErrorIsEnabled;
    String passwordErrorMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // поле "Имя"
    private By nameField = By.xpath(".//label[text()='Имя']/parent::div/input");

    // поле "Email"
    private By emailField = By.xpath(".//label[text()='Email']/parent::div/input");

    // поле "Пароль"
    private By passwordField = By.xpath(".//label[text()='Пароль']/parent::div/input");

    // кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // сообщение об ошибке для поля "Пароль"
    private By passwordError = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_error']/parent::div/p");

    // кнопка "Войти"
    private By loginButtonRegisterPage = By.xpath(".//a[text()='Войти']");

    @Step("клик по кнопке 'Войти'")
    public void loginButtonRegisterPageClick() {
        driver.findElement(loginButtonRegisterPage).click();
    }
    @Step("заполнение поля 'Имя'")
    public void nameFieldInput(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("клик по кнопке 'Зарегистрироваться'")
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }
    @Step("проверка наличия ошибки под полем 'Пароль'")
    public boolean passwordErrorVisibilityCheck() {
        passwordErrorIsEnabled= driver.findElement(passwordError).isEnabled();
        return passwordErrorIsEnabled;
    }
    @Step("получение текста ошибки поля 'Пароль'")
    public String passwordErrorGetMessageText() {
        passwordErrorMessage = driver.findElement(passwordError).getText();
        return passwordErrorMessage;
    }
    @Step("заполнение поля 'Email'")
    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("заполнение поля 'Пароль'")
    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
}
