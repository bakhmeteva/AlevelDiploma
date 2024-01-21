package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import study.alevel.pages.BasePage;

public class MainPage extends BasePage {

    private final String loginBtn = ".//a[@data-cy = 'myolx-link']";
    private final String searchField = ".//input[@id = 'search']";
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

    public void searchItem(String searchText){
        WebElement input = driver.findElement(By.xpath(searchField));
        input.sendKeys(searchText);
        input.sendKeys(Keys.ENTER);
    }


}
