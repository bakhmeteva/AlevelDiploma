package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import study.alevel.pages.BasePage;

public class ChangeFromFooterPage extends BasePage {
    private final String blogTitle = ".//section[(contains(@class, 'header_section'))]//span[contains(@class, 'elementor-heading-title')]";
    public void checkPageName(String text) {
        Assert.assertEquals(driver.findElement(By.xpath(blogTitle)).getText(), text, "new page header");
    }
}
