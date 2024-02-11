package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import study.alevel.pages.BasePage;

import java.util.List;

public class MainPage extends BasePage {

    private final String loginBtn = ".//a[@data-cy = 'myolx-link']";
    private final String searchField = ".//input[@id = 'search']";
    private final String blogBtn = ".//a[text() = 'Блог OLX']";
    private final String mobileApps = ".//a[text() = 'Мобільні додатки']";

    private final String ruLangBtn = ".//header//a[@href = '/']";

    private final String addsHeader = ".//h2[@data-cy = 'home-categories-title']";

    private final String categories = ".//div[@data-testid = 'home-categories-menu-row']//span";
    private final String subCategories = ".//div[contains(@data-testid, 'sub-cat')]//span";
    private final String allAdds = ".//a[contains(@href, 'obyavlenie')]";





    public void clickLogin(){
        driver.findElement(By.xpath(loginBtn)).click();
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

    /**
     *
     * проверяет заголово разделов
     */
    public MainPage checkCategoriesAmount(int categoriesAmount){
        List <WebElement> categoriesElements = driver.findElements(By.xpath(categories));
        Assert.assertEquals(categoriesElements.size(), categoriesAmount, "Amount of categories");
        return this;
    }

    public MainPage checkCategoryExist(String... categoryNames){
        List <String> categoriesElements = getTextFromElements(driver.findElements(By.xpath(categories)));
        for (String categoryName: categoryNames){
            Assert.assertTrue(categoriesElements.contains(categoryName), categoryName  + " is exist in list of categories");}
        return this;
    }

    public MainPage clickCategoryByName(String categoryName) {
        List <WebElement> categoriesElements = driver.findElements(By.xpath(categories));
        List <String> categoriesElementsText = getTextFromElements(categoriesElements);
        scrollIntoView(
                categoriesElements.get(categoriesElementsText.indexOf(categoryName))
                .findElement(By.xpath("..")))
                .click();
        return this;
    }

    public void clickSubCategoryByName(String subCategoryName) {
        List <WebElement> categoriesElements = driver.findElements(By.xpath(subCategories));
        List <String> categoriesElementsText = getTextFromElements(categoriesElements);
        scrollIntoView(
                categoriesElements.get(categoriesElementsText.indexOf(subCategoryName))
                        .findElement(By.xpath("..")))
                .click();
        waiter(2);
    }

    public void clickFirstAdd(){
        scrollIntoView(driver.findElements(By.xpath(allAdds)).get(0)).click();
        waiter(2);
    }
}
