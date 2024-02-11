package study.alevel.tests.serchandfilter;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.core.enums.Language;
import study.alevel.pages.pages.MainPage;
import study.alevel.pages.pages.SearchResultPage;

public class FreeCategory extends BaseTest {

    @Test
    public void checkPriceInFreeAdds() {
        new MainPage()
                .clickCategoryByName("Віддам безкоштовно");
        new SearchResultPage()
                .checkFreePrices(Language.UA);
    }

    @Test
    public void checkPriceInFreeAddsRu() {
        new MainPage()
                .changeLangToRus()
                .clickCategoryByName("Отдам даром");
        new SearchResultPage()
                .checkFreePrices(Language.RU);
    }
}
