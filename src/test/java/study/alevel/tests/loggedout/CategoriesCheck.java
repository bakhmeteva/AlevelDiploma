package study.alevel.tests.loggedout;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.MainPage;

public class CategoriesCheck extends BaseTest {

    @Test
    public void checkCategoriesOnMainPage(){
        new MainPage()
                .checkCategoriesAmount(16)
                .checkCategoryExist("Допомога")
                .checkCategoryExist("Авто")
                .checkCategoryExist("Авто")
                .checkCategoryExist("Авто")
                .checkCategoryExist("Авто")
                .checkCategoryExist("Авто")
                .checkCategoryExist("Авто")
        ;
    }
}
