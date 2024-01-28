package study.alevel.tests.loggedout;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.LoginPage;
import study.alevel.pages.pages.MainPage;

public class LoginNegative extends BaseTest {

    private final String message = "Ми не знайшли профіль із цією адресою електронної пошти. " +
            "Повторіть спробу, використовуючи іншу адресу, або створіть профіль.";

    @Test
    public void loginUserNegative(){
        new MainPage().clickLogin();
        new LoginPage().login("SomeUser@gmail.com", "somePassword")
                .checkFailLoginMessage(message);
    }
}
