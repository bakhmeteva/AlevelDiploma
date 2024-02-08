package study.alevel;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
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

    @BeforeMethod
    public void goToBasePage(){
        BrowserManager.getInstance().open();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Сделать скриншот и сохранить его
            ((TakesScreenshot) BrowserManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
    }

}