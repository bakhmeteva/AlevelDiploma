package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import study.alevel.pages.BasePage;

public class MainPage extends BasePage {

    private final String loginBtn = ".//a[@data-cy = 'myolx-link']";
    private final String blogBtn = ".//a[text() = 'Блог OLX']";


    public void clickLogin(){
        driver.findElement(By.xpath(loginBtn)).click();
    }

    public void showAccMenus(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(loginBtn))).perform();
    }


    public MainPage clickBlog(){
        scrollIntoView(driver.findElement(By.xpath(blogBtn))).click();
        return this;
    }


}
