package study.alevel.tests.footertests;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.MainPage;
import study.alevel.pages.pages.MobileAppsPage;

public class MobileApps extends BaseTest {
    @Test
    public void mobilePageTest(){
        new MainPage().clickMobileApp();
        new MobileAppsPage().checkAppIconsDisplayed();
    }
}
