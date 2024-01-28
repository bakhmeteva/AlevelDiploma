package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import study.alevel.pages.BasePage;

public class MobileAppsPage extends BasePage {

    private String appIcons = ".//div[@class='app-icons']";

    private String appStore = ".//a[contains(@href, 'apple')]";
    private String googleStore = ".//a[contains(@href, 'google')]";


    public MobileAppsPage checkAppIconsDisplayed(){
        WebElement apps = driver.findElement(By.xpath(appIcons));
        Assert.assertTrue(apps.findElement(By.xpath(appStore)).isDisplayed(), "Apple appStore is displayed");
        Assert.assertTrue(apps.findElement(By.xpath(googleStore)).isDisplayed(), "Google store is displayed");
        return this;
    }

}
