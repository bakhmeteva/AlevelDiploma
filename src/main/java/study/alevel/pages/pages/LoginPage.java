package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import study.alevel.pages.BasePage;

public class LoginPage extends BasePage {

    private final String email = "squirrel2020@ukr.net";
    private final String passWord = "Valerya10112020";
    private final String emailField = ".//input[@type = 'email']";
    private final String passField =  ".//input[@type = 'password']";
    private final String loginBtn =  ".//button[@data-testid = 'login-submit-button']";
    private final String failMessage =  ".//form[@data-testid='login-form']//p";

    public LoginPage login() {
        return login(email, passWord);
    }

    public LoginPage login(String email, String passWord) {
        driver.findElement(By.xpath(emailField)).sendKeys(email);
        driver.findElement(By.xpath(passField)).sendKeys(passWord);
        driver.findElement(By.xpath(loginBtn)).click();
        return this;
    }

    public LoginPage checkFailLoginMessage(String message){
        driver.findElement(By.xpath(errorImage)).isDisplayed();
        waiter(0.5);
        Assert.assertEquals(driver.findElement(By.xpath(failMessage)).getText(), message, "Login error message");
        return this;
    }

    public LoginPage checkPageShown(){
        Assert.assertTrue(driver.findElement(By.xpath(emailField)).isDisplayed(), " login page is shown");
        return this;
    }

}
