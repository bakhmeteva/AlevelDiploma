package study.alevel.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import study.alevel.core.BrowserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {
    public final String errorImage =  ".//img[@alt='error']";
    public WebDriver driver = BrowserManager.getInstance().getDriver();

    public WebElement scrollIntoViewMiddle(WebElement elementToScroll){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", elementToScroll);
        waiter(1);
        return elementToScroll;
    }

    public WebElement scrollIntoView(WebElement elementToScroll){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
        waiter(0.2);
        return elementToScroll;
    }

    /**
     * переключается на вкладку с именем
     */
    public void goToTab(String tabName){
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            // Переключаемся на каждую вкладку
            driver.switchTo().window(handle);
            String pageTitle = driver.getTitle();
            if (pageTitle.contains(tabName)) {
                return;
            }
        }
        System.out.println("Вкладка с именем " + tabName + " не найдена");
    }


    public List<String> getTextFromElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(element.getText());
        }
        return textList;
    }

    public void waiter(double seconds){
        try {
            Thread.sleep((long) (1000L * seconds));
        } catch (InterruptedException e) {
            System.out.println("Something went wrong while wait " + e.getMessage());
        }
    }
}
