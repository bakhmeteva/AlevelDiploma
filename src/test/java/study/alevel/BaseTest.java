package study.alevel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import study.alevel.core.BrowserManager;

public class BaseTest {

    @BeforeTest
    public void beforeTest(){
        BrowserManager.initDriver();
    }

    @AfterTest
    public void closeDriver(){
        BrowserManager.getInstance().closeDriver();
    }

    @BeforeMethod
    public void goToBasePage(){
        BrowserManager.getInstance().open();
    }


}