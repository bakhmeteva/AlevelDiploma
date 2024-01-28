package study.alevel.tests.loggedout.serchandfilter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.ChangePageFromFooter;
import study.alevel.pages.pages.MainPage;
import study.alevel.pages.pages.SearchResultPage;

public class SearchAdd extends BaseTest {

    @Parameters({"search", "check"})
    @Test(testName = "Поиск теннисной ракетки")
    public void blogPageTest(String search, String check){
        new MainPage().searchItem(search);
        new SearchResultPage().checkSearchResults(check);
    }
}
