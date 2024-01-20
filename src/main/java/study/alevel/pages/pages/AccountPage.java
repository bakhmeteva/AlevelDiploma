package study.alevel.pages.pages;


import org.openqa.selenium.By;
import org.testng.Assert;
import study.alevel.pages.BasePage;

public class AccountPage extends BasePage {

    private final String addsHead = ".//h3[@data-testid = 'header-title']";
    public void checkIsUserLoggedIn() {
        Assert.assertEquals(driver.findElement(By.xpath(addsHead)).getText(), "Ваші оголошення");
    }
}
