package study.alevel.tests.mainfunc;

import org.testng.annotations.Test;
import study.alevel.BaseTest;
import study.alevel.pages.pages.MainPage;

public class CategoriesCheck extends BaseTest {

    @Test
    public void checkCategoriesOnMainPage() {
        new MainPage()
                .checkCategoriesAmount(16)
                .checkCategoryExist(
                        "Допомога",
                        "Дитячий світ",
                        "Нерухомість",
                        "Авто",
                        "Запчастини для транспорту",
                        "Робота",
                        "Тварини",
                        "Дім і сад",
                        "Електроніка",
                        "Бізнес та послуги",
                        "Оренда та прокат",
                        "Мода і стиль",
                        "Хобі, відпочинок і спорт",
                        "Віддам безкоштовно",
                        "Обмін",
                        "Авто для перемоги"
                );
    }
}
