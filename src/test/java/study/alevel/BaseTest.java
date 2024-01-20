package study.alevel;

import org.testng.annotations.*;
import study.alevel.core.BrowserManager;

public class BaseTest {

    @BeforeTest
    public void beforeSuiteMethod(){
        BrowserManager.initDriver();
    }

    @AfterTest
    public void closeDriver(){
        BrowserManager.getInstance().closeDriver();
    }

    @BeforeClass
    public void gotoBasePage(){
        BrowserManager.getInstance().open();
    }

}