import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.time.Duration;

import static constants.URLs.HOME_PAGE;
public class BaseTest {
   protected WebDriver driver;
   protected MainPage mainPageObj;
   protected LoginPage loginPageObj;
   protected RegisterPage registerPageObj;

    public WebDriver browserSelect() {
        String browser = System.getProperty("browser", "chrome");
        ChromeOptions options = new ChromeOptions();
        if (browser.equals("yandex")) {
             System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("chrome")) {
            driver = new ChromeDriver(options);
        }
       return driver;
    }

    @Before
    public void startUP() {
        driver = browserSelect();
        RestAssured.baseURI = HOME_PAGE;
        mainPageObj = new MainPage(driver);
        loginPageObj = new LoginPage(driver);
        registerPageObj = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}

