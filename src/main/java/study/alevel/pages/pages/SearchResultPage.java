package study.alevel.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import study.alevel.core.enums.Language;
import study.alevel.pages.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {
    private final String searchResultsHeads = ".//div[@type = 'list']//h6";
    private final String searchResultsPrices = ".//div[@type = 'list']//p[@data-testid = 'ad-price']";


    /**
     * проверка результатов поиска
     * @param checkValues строка сплитится по запятой
     */
    public void checkSearchResults(String checkValues){
        List <String> headers = driver.findElements(By.xpath(searchResultsHeads))
                .stream()
                .limit(10) // оставим только первые 10 объявлений
                .map(element -> element.getText().toLowerCase())
                .toList();
        Assert.assertFalse(headers.isEmpty(), "результаты поиска не пустые");
        checkResultsHasText(headers, checkValues);
    }

    /**
     * проверка результатов поиска
     */
    public void checkFreePrices(Language lang){
        String expectedPrice = "безкоштовно";
        if (lang.equals(Language.RU)){
            expectedPrice = "бесплатно";
        }
        List <String> prices = driver.findElements(By.xpath(searchResultsPrices))
                .stream()
                .limit(10) // оставим только первые 10 объявлений
                .map(element -> element.getText().toLowerCase())
                .toList();
        for (String price: prices){
            Assert.assertEquals(price, expectedPrice, "price in add");
        }
    }

    /**
     * проверяет что строки содержат одно из слов
     * @param headers закголовки объявлений
     * @param checkValue строка сплитится по запятой
     */
    private void checkResultsHasText(List <String> headers, String checkValue){
        List<String> keywords = Arrays.asList(checkValue.split(","));
        // Проверка каждого элемента списка headers
        for (String header : headers) {
            boolean containsKeyword = keywords.stream()
                    .anyMatch(keyword -> header.toLowerCase().contains(keyword.trim().toLowerCase()));
            Assert.assertTrue(containsKeyword, "Заголовок '" + header + "' не содержит ни одного из ключевых слов [" + checkValue +"]");
        }
    }

}
