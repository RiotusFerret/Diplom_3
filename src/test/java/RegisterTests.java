import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static constants.URLs.HOME_PAGE;
import static data.TestData.*;

public class RegisterTests extends BaseTest {
    User user = new User(EMAIL, NAME, PASSWORD);
    UserRequests usReq = new UserRequests();

    @After
    public void cleanUp() {
        Response loginResponse = usReq.userLogin(user);
        usReq.userGetToken(loginResponse, user);
        if (user.isCreated()) {
            usReq.userDelete(user);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Регистрация и возврат на страницу авторизации")
    public void successfulRegistrationTest() {
      driver.get(HOME_PAGE);
      mainPageObj.loginButtonMainPageClick();
      loginPageObj.registerButtonLoginPageClick();
      registerPageObj.nameFieldInput(user.getName());
      registerPageObj.emailFieldInput(user.getEmail());
      registerPageObj.passwordFieldInput(user.getPassword());
      registerPageObj.registerButtonClick();
      Assert.assertTrue(loginPageObj.ifLoginButtonIsVisible());
    }

    @Test
    @DisplayName("Регистрация с паролем длиной менее 6 символов")
    @Description("Сообщение об ошибке")
    public void incorrectPasswordRegistrationTest() {
        driver.get(HOME_PAGE);
        mainPageObj.loginButtonMainPageClick();
        loginPageObj.registerButtonLoginPageClick();
        registerPageObj.nameFieldInput(user.getName());
        registerPageObj.emailFieldInput(user.getEmail());
        registerPageObj.passwordFieldInput("12345");
        registerPageObj.registerButtonClick();
        Assert.assertTrue(registerPageObj.passwordErrorVisibilityCheck());
        Assert.assertEquals("Некорректный пароль", registerPageObj.passwordErrorGetMessageText());
    }

}
