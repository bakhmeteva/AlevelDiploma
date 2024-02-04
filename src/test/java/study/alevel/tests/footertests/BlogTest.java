package study.alevel.tests.footertests;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.ChangePageFromFooter;
import study.alevel.pages.pages.MainPage;

public class BlogTest extends BaseTest {

    @Test
    public void blogPageTest(){
        new MainPage().clickBlog()
                .goToTab("блог");
        new ChangePageFromFooter().checkPageName("БЛОГ");
    }
}
