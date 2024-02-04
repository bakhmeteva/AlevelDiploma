package study.alevel.tests.mainfunc;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.AccountPage;
import study.alevel.pages.pages.LoginPage;
import study.alevel.pages.pages.MainPage;

public class LoginUser extends BaseTest {

    @Test
    public void loginUser(){
        new MainPage().clickLogin();
        new LoginPage().login();
        new AccountPage().checkIsUserLoggedIn();
    }

}
