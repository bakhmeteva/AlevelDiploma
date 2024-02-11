package study.alevel.tests.mainfunc;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.MainPage;

public class ChangeLangToRussian extends BaseTest {

    @Test
    public void changeLangToRusTest(){
        new MainPage()
                .checkMainCategoriesHead("Розділи на сервісі OLX")
                .changeLangToRus()
                .checkMainCategoriesHead("Разделы на сервисе OLX");
    }
}
