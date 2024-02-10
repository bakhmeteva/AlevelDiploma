package study.alevel;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import study.alevel.core.BrowserManager;

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

    public void captureScreenshot(ITestResult result) {
        // Преобразование драйвера в объект TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) BrowserManager.getDriver();
        // Получение скриншота как файла
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        // Путь для сохранения скриншота
        String path = "./screenshots/" + result.getName() + ".png";
        // Создание файла скриншота
        File destination = new File(path);
        try {
            // Копирование скриншота в нужное место
            FileUtils.copyFile(screenshot, destination);
            // Добавление скриншота к отчету TestNG
            Reporter.log("Failed test screenshot: <a href='" + path + "'><img src='" + path + "'/></a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}