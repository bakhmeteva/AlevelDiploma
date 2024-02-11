package study.alevel.tests.adds;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.AddsPage;
import study.alevel.pages.pages.LoginPage;
import study.alevel.pages.pages.MainPage;

public class LoggedOutActionsWithAdd extends BaseTest {

    @Test
    public void tryToSendMessage() {
        new MainPage().clickFirstAdd();
        new AddsPage().clickSendMessage();
        new LoginPage().checkPageShown();
    }


    @Test
    public void tryToSeePhoneRight() {
        new MainPage().clickFirstAdd();
        new AddsPage()
                .clickShowPhoneOnRight()
                .checkPhoneVisible();
    }
    @Test
    public void tryToSeePhoneInFooter() {
        new MainPage().clickFirstAdd();
        new AddsPage()
                .clickShowPhoneInFooter()
                .checkPhoneVisible();
    }
}
