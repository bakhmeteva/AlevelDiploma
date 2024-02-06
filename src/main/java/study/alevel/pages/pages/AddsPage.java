package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import study.alevel.core.BrowserManager;
import study.alevel.pages.BasePage;

public class AddsPage extends BasePage {

    private final String showPhoneBtnFooter = ".//button[@data-testid = 'show-phone']";
    private final String showPhoneBtnRight = ".//button[@data-cy = 'ad-contact-phone']";
    private final String sendMessage = ".//button[@data-cy = 'ad-contact-message-button']";
    private final String phone = ".//a[@data-testid = 'contact-phone']";

    public AddsPage clickShowPhoneInFooter(){
        waiter(2);
        scrollIntoViewMiddle(driver.findElement(By.xpath(showPhoneBtnFooter))).click();
        return this;
    }

    public AddsPage clickShowPhoneOnRight(){
        waiter(2);
        scrollIntoViewMiddle(driver.findElement(By.xpath(showPhoneBtnRight))).click();
        return this;
    }

    public AddsPage clickSendMessage(){
        waiter(2);
        scrollIntoViewMiddle(driver.findElement(By.xpath(sendMessage))).click();
        return this;
    }

    public AddsPage checkPhoneVisible(){
        Assert.assertTrue(driver.findElement(By.xpath(phone)).isDisplayed(), " login page is shown");
        return this;
    }

}
