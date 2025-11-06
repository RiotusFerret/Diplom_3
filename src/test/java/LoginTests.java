import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static constants.URLs.HOME_PAGE;
import static data.TestData.*;

public class LoginTests extends BaseTest {
    User user = new User(EMAIL, NAME, PASSWORD);
    UserRequests usReq = new UserRequests();

    @After
    public void cleanUp() {
        if (user.isCreated()) {
            usReq.userDelete(user);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void loginButtonMainPageLoginTest() {
        usReq.userCreate(user);
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
         mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible()); // возможность зайти в личный кабинет
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет» на главной странице")
    public void personalCabinetButtonMainPageLoginTest() {
        usReq.userCreate(user);
        driver.get(HOME_PAGE);
        mainPageObj.personalCabinetButtonMainPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
          mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible()); // возможность зайти в личный кабинет
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void registerFormLoginTest() {
        usReq.userCreate(user);
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.registerButtonLoginPageClick();
        registerPageObj.loginButtonRegisterPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
        mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible()); // возможность зайти в личный кабинет
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void forgotPasswordPageLoginTest() {
        usReq.userCreate(user);
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.restorePasswordButtonClick();
        loginPageObj.loginButtonForgotPasswordPageClick();
        loginPageObj.emailAuthFieldInput(user.getEmail());
        loginPageObj.passwordAuthFieldInput(user.getPassword());
        loginPageObj.loginButtonClick();
        mainPageObj.personalCabinetButtonMainPageClick();
        Assert.assertTrue(mainPageObj.profileIsVisible()); // возможность зайти в личный кабинет
    }
}
