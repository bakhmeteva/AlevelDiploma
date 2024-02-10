package study.alevel;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import study.alevel.core.BrowserManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

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
            captureScreenshot(result);
        }
    }

    private void captureScreenshot() {
        try {
            // Преобразование драйвера в объект TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) BrowserManager.getDriver();
            // Получение скриншота как массива байт
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // Добавление скриншота к отчету Allure
            Allure.addAttachment("Page screenshot", new ByteArrayInputStream(screenshot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}