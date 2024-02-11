package study.alevel.tests.footertests;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.ChangeFromFooterPage;
import study.alevel.pages.pages.MainPage;

public class BlogTest extends BaseTest {

    @Test
    public void blogPage(){
        new MainPage()
                .clickBlog()
                .goToTab("блог");
        new ChangeFromFooterPage()
                .checkPageName("БЛОГ");
    }
}
