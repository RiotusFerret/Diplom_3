import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static constants.URLs.HOME_PAGE;
import static data.TestData.*;

public class LoginTests extends BaseTest {
    User user = new User(EMAIL, NAME, PASSWORD);
    UserRequests usReq = new UserRequests();

    @Before
    public void startUp() {
        Response loginResponse = usReq.userCreate(user);
        usReq.userGetToken(loginResponse, user);
    }

    @After
    public void cleanUp() {
        if (user.isCreated()) {
            usReq.userDelete(user);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Регистрация и вход в личный кабинет")
    public void loginButtonMainPageLoginTest() {
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
         mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible());
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет» на главной странице")
    @Description("Регистрация и вход в личный кабинет")
    public void personalCabinetButtonMainPageLoginTest() {
        driver.get(HOME_PAGE);
        mainPageObj.personalCabinetButtonMainPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
        mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Регистрация и вход в личный кабинет")
    public void registerFormLoginTest() {
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.registerButtonLoginPageClick();
        registerPageObj.loginButtonRegisterPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
        mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Регистрация и вход в личный кабинет")
    public void forgotPasswordPageLoginTest() {
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.restorePasswordButtonClick();
        loginPageObj.loginButtonForgotPasswordPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
        mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible());
    }
}
