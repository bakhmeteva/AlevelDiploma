package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import study.alevel.pages.BasePage;

public class MainPage extends BasePage {

    private final String loginBtn = ".//a[@data-cy = 'myolx-link']";
    private final String searchField = ".//input[@id = 'search']";
    private final String blogBtn = ".//a[text() = 'Блог OLX']";
    private final String mobileApps = ".//a[text() = 'Мобільні додатки']";

    private final String ruLangBtn = ".//header//a[@href = '/']";

    private final String addsHeader = "//h2[@data-cy = 'home-categories-title']";



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

    public MainPage clickMobileApp(){
        scrollIntoView(driver.findElement(By.xpath(mobileApps))).click();
        return this;
    }

    public void searchItem(String searchText){
        WebElement input = driver.findElement(By.xpath(searchField));
        input.sendKeys(searchText);
        input.sendKeys(Keys.ENTER);
    }

    /**
     * проверяет заголово разделов
     */
    public MainPage checkMainCategoriesHead(String addHeader){
        Assert.assertEquals(driver.findElement(By.xpath(addsHeader)).getText(), addHeader, "Загловок разделов OLX");
        return this;
    }

    /**
     * Меняет язык на русский
     */
    public MainPage changeLangToRus(){
        driver.findElement(By.xpath(ruLangBtn)).click();
        return this;
    }

}
