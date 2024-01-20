package study.alevel.pages.pages;

import org.openqa.selenium.By;
import study.alevel.pages.BasePage;

public class LoginPage extends BasePage {

    private final String email = "squirrel2020@ukr.net";
    private final String passWord = "Valerya10112020";
    private final String emailField = ".//input[@type = 'email']";
    private final String passField =  ".//input[@type = 'password']";
    private final String loginBtn =  ".//button[@data-testid = 'login-submit-button']";

    public void login() {
        driver.findElement(By.xpath(emailField)).sendKeys(email);
        driver.findElement(By.xpath(passField)).sendKeys(passWord);
        driver.findElement(By.xpath(loginBtn)).click();
    }

}
