package study.alevel.tests.serchandfilter;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.core.enums.Currencies;
import study.alevel.pages.pages.MainPage;
import study.alevel.pages.pages.SearchResultPage;

public class PriceFilterTest extends BaseTest {

    @Test
    public void checkPriceDiapasonInFilter() {
        new MainPage()
                .clickCategoryByName("Нерухомість")
                .clickSubCategoryByName("Квартири");
        int fromPrice = 10000;
        int toPrice = 20000;
        new SearchResultPage()
                .inputRangeInFilterByName("Ціна", fromPrice, toPrice, Currencies.UAH)
                .checkPriceRange(fromPrice, toPrice);
    }

    @Test
    public void checkPriceDiapasonInFilterReverces() {
        new MainPage()
                .clickCategoryByName("Нерухомість")
                .clickSubCategoryByName("Квартири");
        int fromPrice = 20000;
        int toPrice = 10000;
        new SearchResultPage()
                .inputRangeInFilterByName("Ціна", fromPrice, toPrice, Currencies.UAH)
                .checkRangeInFilterByName("Ціна", toPrice, fromPrice)
                .checkPriceRange(toPrice, fromPrice);
    }

    @Test
    public void checkPriceDiapasonInFilterDirect() {
        new MainPage().
                clickCategoryByName("Нерухомість")
                .clickSubCategoryByName("Квартири");
        int fromPrice = 20000;
        int toPrice = 20000;
        new SearchResultPage()
                .inputRangeInFilterByName("Ціна", toPrice, fromPrice, Currencies.UAH)
                .checkPriceRange(fromPrice, toPrice);
    }
}
