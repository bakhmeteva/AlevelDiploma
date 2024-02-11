package study.alevel.tests.serchandfilter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.core.enums.Currencies;
import study.alevel.pages.pages.MainPage;
import study.alevel.pages.pages.SearchResultPage;

import static study.alevel.core.enums.Currencies.*;

public class CurrencyChange extends BaseTest {

    @DataProvider
    public Object[] currency() {
        return new Object[] {
                USD,
                UAH,
                EUR
        };
    }

    @Test(dataProvider = "currency")
    public void checkChangeCurrency(Currencies currency){
        new MainPage().
                clickCategoryByName("Авто")
                .clickSubCategoryByName("Легкові автомобілі");
        new SearchResultPage()
                .selectCurrency(currency)
                .checkPricesContains(currency.getSymbol());
    }
}
